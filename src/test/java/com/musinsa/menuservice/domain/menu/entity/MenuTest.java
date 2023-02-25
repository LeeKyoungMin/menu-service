package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void testConstructor() {
        Long id = 1L;
        String title = "Example";
        String link = "/example.com";
        String parentId = "parent1";
        List<Menu> child = new ArrayList<>();
    
        Menu menu = new Menu(id, title, link, parentId, child);
    
        assertEquals(id, menu.getId());
        assertEquals(title, menu.getTitle());
        assertEquals(link, menu.getLink());
        assertEquals(parentId, menu.getParentId());
        assertEquals(child, menu.getChild());
    }

}