package com.musinsa.menuservice.domain.menu.dto;

import java.util.Collections;
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
    private MenuDto parent;
    private Banner banner;
    private List<MenuDto> childs;

    public MenuDto(String id, String title, String link, MenuDto parent, Banner banner, List<MenuDto> childs){
        this.id = id;
        this.title = title;
        this.link = link;
        this.parent = parent;
        this.banner = banner;
        this.childs = childs;
    }

    public static MenuDto from(Menu menu) {
        if (menu == null) {
            return null;
        }

        MenuDto parent = null;

        if (menu.getParent() != null) {
            parent = new MenuDto(
                    menu.getParent().getId(),
                    menu.getParent().getTitle(),
                    menu.getParent().getLink(),
                    null,
                    menu.getParent().getBanner(),
                    Collections.emptyList()
            );
        }

        List<MenuDto> childs = menu.getChilds().stream()
                                                .map(MenuDto::from)
                                                .collect(Collectors.toList());

        return new MenuDto(menu.getId(), menu.getTitle(), menu.getLink(), parent, menu.getBanner(), childs);
    }
}