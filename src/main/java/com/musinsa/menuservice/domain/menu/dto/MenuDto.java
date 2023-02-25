package com.musinsa.menuservice.domain.menu.dto;

import java.util.List;

import com.musinsa.menuservice.domain.menu.entity.Banner;
import com.musinsa.menuservice.domain.menu.entity.Menu;

public record MenuDto(String id, String title, String link, String parentId, Banner banner, List<Menu> childs) {
    
}
