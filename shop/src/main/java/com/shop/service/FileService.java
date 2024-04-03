package com.shop.service;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@Log
//파일 업로드와 삭제 처리를 담당
public class FileService {

    public String uploadFile(String uploadPath, String originalFileName,
                             byte[] fileData) throws Exception {
        //각 개체들을 구별하기 위해 이름을 부여할 때 사용
        //중복 가능성이 거의 없어 파일이름으로 사용하면 중복 문제 해결
        UUID uuid = UUID.randomUUID();
        
        //UUID 값과 원래 파일의 이름의 확장자를 조합해서 저장될 파일 이름 만듦
        String extension = originalFileName.substring(originalFileName
                .lastIndexOf("."));
        String savedFileName = uuid.toString() + extension;
        String fileUploadFullUrl = uploadPath + "/" + savedFileName;

        //파일을 저장하기 위해 스트림으로 변환
        FileOutputStream fos = new FileOutputStream(fileUploadFullUrl);
        fos.write(fileData);
        fos.close();

        return savedFileName;
    }

    public void deleteFile(String filePath) throws Exception {
        File deleteFile = new File(filePath);

        if(deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
