package com.musinsa.menuservice.domain.menu.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.dto.MenuCommand;
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

        if (StringUtils.hasText(command.parentId())) {
            parentMenu = menuRepository.findById(command.parentId()).orElseThrow();
            
            Menu newMenu = Menu.builder()
                .title(command.title())
                .link(command.link())
                .parent(parentMenu)
                .banner(command.banner())
                .childs(new ArrayList<>())
                .build();

            parentMenu.add(newMenu);
        
            savedMenu = menuRepository.save(parentMenu);
        }else{
            Menu newMenu = Menu.builder()
                .title(command.title())
                .link(command.link())
                .parent(parentMenu)
                .banner(command.banner())
                .childs(command.childs())
                .build();
            savedMenu = menuRepository.save(newMenu);
        }

        MenuDto savedMenuDto = new MenuDto(savedMenu);

        return savedMenuDto;
    }

    @Transactional
    public void updateMenu(String id, MenuCommand command) {
        
        Menu menu = menuRepository.findById(id).orElseThrow();
        
        MenuDto menuDto = new MenuDto(menu);
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
}
