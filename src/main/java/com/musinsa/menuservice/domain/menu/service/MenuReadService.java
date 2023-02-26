package com.musinsa.menuservice.domain.menu.service;

import org.springframework.stereotype.Service;

import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.entity.Menu;
import com.musinsa.menuservice.domain.menu.repository.MenuRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MenuReadService {

    private final MenuRepository menuRepository;

    public MenuDto toDto(Menu menu){
        return new MenuDto(menu);
    }
}
