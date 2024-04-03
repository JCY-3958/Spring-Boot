package com.shop.service;

import com.shop.dto.ItemFormDto;
import com.shop.entity.Item;
import com.shop.entity.ItemImg;
import com.shop.repository.ItemImgRepository;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
//상품을 등록하는 클래스
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto,
                         List<MultipartFile> itemImgFileList) throws Exception {
        //상품 등록
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        //이미지 등록
        //첫 번째 이미지일 경우 대표 상품 이미지 여부 값을 Y로
        //나머지는 N으로 설정
        for(int i=0; i < itemImgFileList.size(); i++) {
            ItemImg itemImg = new ItemImg();
            
            //상품 이미지 리스트가 5개가 있는데 첫 번째 이미지만 넣었을 때
            //DB에 나머지 비어있는 리스트가 들어감. 그것을 방지함
            //잠시 뭔가 이상함
            if(itemImgFileList.get(i).isEmpty()) {
                continue;

            }
            itemImg.setItem(item);
            if(i == 0)
                itemImg.setRepimgYn("Y");
            else
                itemImg.setRepimgYn("N");

            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }

        return item.getId();
    }
}
