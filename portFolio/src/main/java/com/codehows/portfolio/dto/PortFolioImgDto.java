package com.codehows.portfolio.dto;

import com.codehows.portfolio.entity.PortfFolioImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class PortFolioImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;

    private static ModelMapper modelMapper = new ModelMapper();

    public static PortFolioImgDto of(PortfFolioImg portfFolioImg) {
        return modelMapper.map(portfFolioImg, PortFolioImgDto.class);
    }
}
