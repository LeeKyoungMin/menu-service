package com.musinsa.menuservice.domain.menu.dto;

import java.util.ArrayList;

import com.musinsa.menuservice.domain.banner.entity.Banner;
import com.musinsa.menuservice.domain.menu.entity.Menu;

public record MenuCommand(String id, String title, String link, String parentId, Banner banner, ArrayList<Menu> childs) {
    
}
