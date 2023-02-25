package com.musinsa.menuservice.domain.menu.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import java.util.Objects;

@Getter
public class Menu {
    private final Long id;

    private String title;

    private String link;

    private final String parentId;

    private Banner banner;

    private List<Menu> child = new ArrayList<Menu>();

    @Builder
    public Menu(Long id, String title, String link, String parentId, Banner banner, List<Menu> child){
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.link = Objects.requireNonNull(link);
        this.parentId = Objects.requireNonNull(parentId);
        this.banner = banner;
        this.child = child;
    }
}
