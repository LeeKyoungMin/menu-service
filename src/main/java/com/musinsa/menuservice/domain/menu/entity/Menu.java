package com.musinsa.menuservice.domain.menu.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.musinsa.menuservice.domain.banner.entity.Banner;
import com.musinsa.menuservice.domain.menu.dto.MenuDto;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    @Embedded
    private Banner banner;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Menu> childs = new ArrayList<Menu>();

    @Builder
    public Menu(String id, String title, String link, Menu parent, Banner banner, List<Menu> childs){
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.link = Objects.requireNonNull(link);
        this.parent = parent;
        if(parent != null && parent.getId() != null){
            if(banner != null){
                throw new IllegalArgumentException("Banner Register Ban");
            }
            this.banner = null;
        }else{
            this.banner = banner;
        }
        this.childs = childs;
    }

    public static Menu to(MenuDto menuDto) {
        if (menuDto == null || menuDto.getId() == null) {
            return null;
        }

        Menu parent = null;

        if (menuDto.getParent() != null) {
            parent = new Menu(
                    menuDto.getParent().getId(),
                    menuDto.getParent().getTitle(),
                    menuDto.getParent().getLink(),
                    null,
                    menuDto.getParent().getBanner(),
                    Collections.emptyList()
            );
        }

        List<Menu> childs = menuDto.getChilds().stream()
                                                .map(Menu::to)
                                                .collect(Collectors.toList());

        return new Menu(menuDto.getId(), menuDto.getTitle(), menuDto.getLink(), parent, menuDto.getBanner(), childs);
    }

    public Menu(){}

    public void add(Menu childs){
        this.childs.add(childs);
    }

    public void remove(Menu menu){
        if(this.childs.isEmpty()){
            throw new IndexOutOfBoundsException();
        }

        for(int i = 0; i < childs.size(); i++){
            if(childs.get(i).getId().equals(menu.getId())){
                childs.set(i, null);
            }
        }
    }
}
