package com.musinsa.menuservice.domain.menu.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.musinsa.menuservice.domain.banner.entity.Banner;

class MenuTest {

    private Banner banner;

    private Menu menu;

    private Menu newMenu;

    @BeforeEach
    void setUp(){
        banner = Banner.builder()
                              .imageUrl("/test.com")
                              .linkUrl("/redirect.image.com")
                              .build();
        menu = Menu.builder()
                        .id("1234-123aa")
                        .title("test")
                        .link("/test.example.com")
                        .parent(new Menu())
                        .banner(banner)
                        .childs(new ArrayList<Menu>())
                        .build();
        newMenu = Menu.builder()
                          .id("1234-123cc")
                          .title("test")
                          .link("/test.example.com")
                          .parent(menu)
                          .banner(banner)
                          .childs(new ArrayList<Menu>())
                          .build();
    }

    @DisplayName("[Entity] 메뉴 Entity 테스트")
    @Test
    void testConstructor() {

        //given
        String id = "123asd-asdzxc1";
        String title = "Example";
        String link = "/example.com";
        Menu parent = newMenu;
        Banner banner = new Banner("/main.banner.com", "/banner.com");
        ArrayList<Menu> child = new ArrayList<>();
    
        //when
        var menu = new Menu(id, title, link, parent, banner, child);
    
        //then
        assertEquals(id, menu.getId());
        assertEquals(title, menu.getTitle());
        assertEquals(link, menu.getLink());
        assertEquals(parent, menu.getParent());
        assertEquals(banner, menu.getBanner());
        assertEquals(child, menu.getChilds());
    }

    @DisplayName("[Entity] 배너 Entity add 테스트")
    @Test
    void add(){

        //given
        //setUp()

        //when
        menu.add(newMenu);

        //then
        assertEquals(menu.getId(), newMenu.getParent().getId());
    }

    @DisplayName("[Entity] 배너 Entity remove 테스트")
    @Test
    void remove(){

        //given
        //setUp()

        //when
        menu.add(newMenu);
        menu.remove(newMenu);

        //then
        assertFalse(menu.getChilds().contains(newMenu));
    }

}
