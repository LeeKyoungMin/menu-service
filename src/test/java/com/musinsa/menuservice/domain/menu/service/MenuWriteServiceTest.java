package com.musinsa.menuservice.domain.menu.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.musinsa.menuservice.domain.banner.entity.Banner;
import com.musinsa.menuservice.domain.menu.dto.MenuCommand;
import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.entity.Menu;
import com.musinsa.menuservice.domain.menu.repository.MenuRepository;

@ExtendWith(MockitoExtension.class)
public class MenuWriteServiceTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuWriteService menuWriteService;

    private Banner banner;

    private Menu menu;

    private MenuCommand menuCommand;

    @BeforeEach
    void setUp(){

        banner = Banner.builder()
                        .imageUrl("/banner.image.com")
                        .linkUrl("/redirect.link.banner.com")
                        .build();
        
    }

    @DisplayName("[Service] 매뉴 Service create 테스트(하위 등록일때)")
    @Test
    void createMenuWithChildsTest(){

        //given
        String parentId = "39e57a6d-e4ef-4b61-9cd7-13d680ed4c76";
        Menu parentMenu = Menu.builder()
                        .id(parentId)
                        .title("test")
                        .link("/test.example.com")
                        .banner(banner)
                        .childs(new ArrayList<Menu>())
                        .build();
        menuCommand = new MenuCommand(
                        "",
                        "test",
                        "/test.menu.com",
                        parentId,
                        banner,
                        new ArrayList<MenuDto>()
                        );

        when(menuRepository.findById(parentId)).thenReturn(Optional.of(parentMenu));
        when(menuRepository.save(any(Menu.class))).thenReturn(new Menu());

        //when
        MenuDto savedMenu = menuWriteService.createMenu(menuCommand);

        //then
        assertNotNull(savedMenu);
    }

    @DisplayName("[Service] 매뉴 Service create 테스트(최초 등록할때)")
    @Test
    void createMenuTest(){

        //given
        menu = Menu.builder()
                        .id("1234-123aa")
                        .title("test")
                        .link("/test.example.com")
                        .parent(new Menu())
                        .banner(banner)
                        .childs(new ArrayList<Menu>())
                        .build();

        menuCommand = new MenuCommand(
                        "",
                        "test",
                        "/test.menu.com",
                        null,
                        banner,
                        new ArrayList<MenuDto>()
                        );

        when(menuRepository.save(any(Menu.class))).thenReturn(menu);
        
        //when
        MenuDto newMenuDto = menuWriteService.createMenu(menuCommand);
        
        //then
        verify(menuRepository, times(1)).save(any(Menu.class));
        assertEquals(newMenuDto.getId(), menu.getId());
    }

    @DisplayName("[Service] 매뉴 Service update 테스트")
    @Test
    void updatedMenuTest(){

        //given
        String menuId = "cef5e424-52e7-417a-8af7-d62195073708";
        menu = Menu.builder()
                        .id(menuId)
                        .title("test")
                        .link("/test.example.com")
                        .parent(new Menu())
                        .banner(banner)
                        .childs(new ArrayList<Menu>())
                        .build();

        when(menuRepository.findById(menuId)).thenReturn(Optional.of(menu));

        menuCommand = new MenuCommand(
                menuId,
                "test",
                "/redirect.com",
                null,
                null,
                new ArrayList<MenuDto>()
                );           

        //when
        menuWriteService.updateMenu(menuId, menuCommand);

        //then
        verify(menuRepository, times(1)).save(any(Menu.class));
    }

    @DisplayName("[Service] 메뉴 Service delete 테스트")
    @Test
    void deleteMenuTest(){
        String menuId = "cef5e424-52e7-417a-8af7-d62195073708";

        menu = Menu.builder()
                        .id(menuId)
                        .title("test")
                        .link("/test.example.com")
                        .parent(new Menu())
                        .banner(banner)
                        .childs(new ArrayList<Menu>())
                        .build();
        when(menuRepository.findById(menuId)).thenReturn(Optional.of(menu));

        menuWriteService.deleteMenu(menuId);

        verify(menuRepository, times(1)).delete(any(Menu.class));
    }
}
