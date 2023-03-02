package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.musinsa.menuservice.domain.banner.entity.Banner;

public class BannerTest {
    @Test
    void testConstructor() {
        String imageUrl = "/banner.example.com";
        String linkUrl = "/example.banner.com";
    
        var banner = new Banner(imageUrl, linkUrl);
    
        assertEquals(imageUrl, banner.getImageUrl());
        assertEquals(linkUrl, banner.getLinkUrl());
    }
}
