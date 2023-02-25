package com.musinsa.menuservice.domain.menu.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Banner {
    private final Long id;

    private final String imageUrl;

    private final String linkUrl;

    @Builder
    public Banner(Long id, String imageUrl, String linkUrl){
        this.id = id;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }
}
