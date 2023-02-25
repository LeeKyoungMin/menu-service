package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BannerTest {
    @Test
    void testConstructor() {
        Long id = 1L;
        String imageUrl = "/banner.example.com";
        String linkUrl = "/example.banner.com";
    
        Banner banner = new Banner(id, imageUrl, linkUrl);
    
        assertEquals(id, banner.getId());
        assertEquals(imageUrl, banner.getImageUrl());
        assertEquals(linkUrl, banner.getLinkUrl());
    }
}
