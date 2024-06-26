package com.codehows.portfolio.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/tui-editor")
public class FileApiController {

    //파일을 업로드할 디렉터리 경로
    private final String uploadDir = Paths.get("C:","tui-editor", "upload").toString();

    //에디터 이미지 업로드
    @PostMapping("/image-upload")
    public String uploadEditorImage(@RequestParam final MultipartFile image) {
        if(image.isEmpty()) {
            return "";
        }

        String orgFilename = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = orgFilename.substring(orgFilename.lastIndexOf(".") + 1);
        String saveFilename = uuid + "." + extension;
        String fileFullPath = Paths.get(uploadDir, saveFilename).toString();

        //uploadDir에 해당되는 디렉터리가 없으면 uploadDir에 포함되는 전체 디렉터리 생성
        File dir = new File(uploadDir);
        if(dir.exists() == false) {
            dir.mkdirs();
        }

        try {
            //파일 저장
            File uploadFile = new File(fileFullPath);
            image.transferTo(uploadFile);
            return saveFilename;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //디스크에 업로드된 파일을 byte로 변환
    @GetMapping(value = "/image-print", produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public byte[] printEditorImage(@RequestParam final String filename) {
        //업로드된 파일의 전체 경로
        String fileFullPath = Paths.get(uploadDir, filename).toString();

        //파일이 없는 경우 예외

        File uploadedFile = new File(fileFullPath);
        if(uploadedFile.exists() == false) {
            throw new RuntimeException();
        }

        try {
            //이미지 파일을 byte로 변환 후 반환
            byte[] imageBytes = Files.readAllBytes(uploadedFile.toPath());
            return imageBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
