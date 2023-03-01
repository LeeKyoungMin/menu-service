package com.musinsa.menuservice.domain.menu.dto;

import java.util.List;

import com.musinsa.menuservice.domain.banner.entity.Banner;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MenuCommand {
    private String id;
    private String title;
    private String link;
    private String parentId;
    private Banner banner;
    private List<MenuDto> childs;

}
