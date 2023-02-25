package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void testConstructor() {
        String id = "123asd-asdzxc1";
        String title = "Example";
        String link = "/example.com";
        String parentId = "fasd2asd-123123";
        Banner banner = new Banner("5123-asda-123aca", "/main.banner.com", "/banner.com");
        List<Menu> child = new ArrayList<>();
    
        Menu menu = new Menu(id, title, link, parentId, banner, child);
    
        assertEquals(id, menu.getId());
        assertEquals(title, menu.getTitle());
        assertEquals(link, menu.getLink());
        assertEquals(parentId, menu.getParentId());
        assertEquals(banner, menu.getBanner());
        assertEquals(child, menu.getChild());
    }

}
