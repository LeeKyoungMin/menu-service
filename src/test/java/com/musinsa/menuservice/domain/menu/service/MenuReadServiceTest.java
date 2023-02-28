package com.musinsa.menuservice.domain.menu.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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
import com.musinsa.menuservice.domain.menu.entity.Menu;
import com.musinsa.menuservice.domain.menu.repository.MenuRepository;

@ExtendWith(MockitoExtension.class)
public class MenuReadServiceTest {
    
    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuReadService menuReadService;

    private Banner banner;

    @BeforeEach
    void setUp(){

        banner = Banner.builder()
                        .imageUrl("/banner.image.com")
                        .linkUrl("/redirect.link.banner.com")
                        .build();
        
    }

    @DisplayName("[Service] 메뉴 전체조회 테스트")
    @Test
    void testGetMenus() {
        
        var menus = menuReadService.getMenus();

        assertNotNull(menus);
    }

    @DisplayName("[Service] 메뉴 조회 테스트")
    @Test
    void testGetMenu() {
        String menuId = "cef5e424-52e7-417a-8af7-d62195073708";

        Menu menu = Menu.builder()
                        .id(menuId)
                        .banner(banner)
                        .title("zz")
                        .link("test")
                        .childs(new ArrayList<Menu>())
                        .build();
        
        when(menuRepository.findById(menuId)).thenReturn(Optional.of(menu));

        var resultDto = menuReadService.getMenu(menuId);

        assertNotNull(resultDto);
        assertEquals(menuId, resultDto.getId());
    }

}
