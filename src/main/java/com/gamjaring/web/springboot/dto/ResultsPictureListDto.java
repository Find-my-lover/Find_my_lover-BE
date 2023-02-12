package com.gamjaring.web.springboot.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResultsPictureListDto {

    private String url;
    private int pose_num;
    private int clothes_num;


}
