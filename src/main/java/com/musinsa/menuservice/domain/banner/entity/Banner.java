package com.musinsa.menuservice.domain.banner.entity;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Embeddable
public class Banner {

    private String imageUrl;

    private String linkUrl;

    @Builder
    public Banner(String imageUrl, String linkUrl){
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }

    Banner(){}
}
