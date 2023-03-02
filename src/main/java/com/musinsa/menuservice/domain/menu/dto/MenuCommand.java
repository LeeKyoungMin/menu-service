package com.musinsa.menuservice.domain.menu.dto;

import java.util.List;

import com.musinsa.menuservice.domain.banner.entity.Banner;

import lombok.Getter;

@Getter
public class MenuCommand {
    private String id;
    private String title;
    private String link;
    private String parentId;
    private Banner banner;
    private List<MenuDto> childs;

    public MenuCommand(){}

    public MenuCommand(String id, String title, String link, String parentId, Banner banner, List<MenuDto> childs){
        this.id = id;
        this.title = title;
        this.link = link;
        this.parentId = parentId;
        this.banner = banner;
        this.childs = childs;
    }
}
