package com.musinsa.menuservice.domain.banner.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Banner {

    private String imageUrl;

    private String linkUrl;

    @Builder
    public Banner(String imageUrl, String linkUrl){
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }
}
