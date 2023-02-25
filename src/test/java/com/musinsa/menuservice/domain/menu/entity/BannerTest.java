package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.musinsa.menuservice.domain.banner.entity.Banner;

public class BannerTest {
    @Test
    void testConstructor() {
        String imageUrl = "/banner.example.com";
        String linkUrl = "/example.banner.com";
    
        Banner banner = new Banner(imageUrl, linkUrl);
    
        assertEquals(imageUrl, banner.getImageUrl());
        assertEquals(linkUrl, banner.getLinkUrl());
    }

    @Test
    void add(){
        Banner banner = Banner.builder().imageUrl("/test.com").linkUrl("/redirect.image.com").build();
        Menu menu = Menu.builder().id("1234-123aa").title("test").link("/test.example.com").parentId("").banner(banner).childs(new ArrayList<Menu>()).build();
        Menu newMenu = Menu.builder().id("1234-123cc").title("test").link("/test.example.com").parentId("1234-123aa").banner(banner).childs(new ArrayList<Menu>()).build();

        menu.add(newMenu);

        assertEquals(menu.getId(), newMenu.getParentId());
    }

    @Test
    void remove(){
        Banner banner = Banner.builder().imageUrl("/test.com").linkUrl("/redirect.image.com").build();
        Menu menu = Menu.builder().id("1234-123aa").title("test").link("/test.example.com").parentId("").banner(banner).childs(new ArrayList<Menu>()).build();
        Menu newMenu = Menu.builder().id("1234-123cc").title("test").link("/test.example.com").parentId("1234-123aa").banner(banner).childs(new ArrayList<Menu>()).build();

        menu.add(newMenu);

        menu.remove(newMenu);

        assertFalse(menu.getChilds().contains(newMenu));
    }
}
