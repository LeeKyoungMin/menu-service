package com.musinsa.menuservice.domain.menu.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.musinsa.menuservice.domain.menu.dto.MenuCommand;
import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.entity.Menu;
import com.musinsa.menuservice.domain.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuWriteService {

    private final MenuRepository menuRepository;

    @Transactional
    public MenuDto createMenu(MenuCommand command) {

        Menu parentMenu = null;
        Menu savedMenu = null;

        if (StringUtils.hasText(command.parentId())) { //하위메뉴 등록할때
            parentMenu = getMenuById(command.parentId());
            
            var newMenu = Menu.builder()
                               .title(command.title())
                               .link(command.link())
                               .parent(parentMenu)
                               .childs(new ArrayList<Menu>())
                               .build();

            parentMenu.add(newMenu);
        
            savedMenu = menuRepository.save(parentMenu);
        }else{ //최상위 메뉴 등록할때
            var newMenu = Menu.builder()
                               .title(command.title())
                               .link(command.link())
                               .parent(parentMenu)
                               .banner(command.banner())
                               .childs(command.childs())
                               .build();
            savedMenu = menuRepository.save(newMenu);
        }

        var savedMenuDto = MenuDto.from(savedMenu);

        return savedMenuDto;
    }

    @Transactional
    public void updateMenu(String id, MenuCommand command) {
        
        var menu = getMenuById(id);
        
        var menuDto = MenuDto.from(menu);
        menu = Menu.builder()
                    .id(id)
                    .title(command.title())
                    .link(command.link())
                    .parent(new Menu(menuDto.getParent()))
                    .banner(command.banner())
                    .childs(command.childs())
                    .build();
        
        menuRepository.save(menu);
    }

    @Transactional
    public void deleteMenu(String id) {
        var menu = getMenuById(id);
        menuRepository.delete(menu);
    }

    private Menu getMenuById(String id) {
        return menuRepository.findById(id).orElseThrow();
    }

}
