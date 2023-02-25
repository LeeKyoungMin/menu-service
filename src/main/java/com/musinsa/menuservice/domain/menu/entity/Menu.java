package com.musinsa.menuservice.domain.menu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Menu {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String title;

    private String link;

    private String parentId;

    private Banner banner;

    private List<Menu> child = new ArrayList<Menu>();

    @Builder
    public Menu(String id, String title, String link, String parentId, Banner banner, List<Menu> child){
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.link = Objects.requireNonNull(link);
        this.parentId = parentId;
        this.banner = banner;
        this.child = child;
    }
}
