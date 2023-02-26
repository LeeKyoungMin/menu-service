package com.musinsa.menuservice.domain.menu.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.musinsa.menuservice.domain.banner.entity.Banner;
import com.musinsa.menuservice.domain.menu.entity.Menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDto{
    private String id;
    private String title;
    private String link;
    private Banner banner;
    private List<MenuDto> childs;

    public MenuDto(Menu menu){
        this.id = menu.getId();
        this.title = menu.getTitle();
        this.link = menu.getLink();
        this.banner = menu.getBanner();
        this.childs = menu.getChilds().stream().map(MenuDto::new).collect(Collectors.toList());
    }

    public MenuDto(String id, String title, String link, Banner banner, List<MenuDto> childs){
        this.id = id;
        this.title = title;
        this.link = link;
        this.banner = banner;
        this.childs = childs;
    }
}