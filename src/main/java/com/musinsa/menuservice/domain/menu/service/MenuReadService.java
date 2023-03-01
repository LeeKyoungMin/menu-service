package com.musinsa.menuservice.domain.menu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuReadService {

    private final MenuRepository menuRepository;

    @Transactional(readOnly = true)
    public List<MenuDto> getMenus(){
        var menus = menuRepository.findAll();

        return menus.stream()
                    .map(MenuDto::from)
                    .toList();
    }

    @Transactional(readOnly = true)
    public MenuDto getMenu(String id){
        var menu = menuRepository.findById(id).orElseThrow();
        var menuDto = MenuDto.from(menu);
        return menuDto;
    }
}
