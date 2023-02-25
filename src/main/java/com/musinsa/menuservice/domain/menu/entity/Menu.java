package com.musinsa.menuservice.domain.menu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.musinsa.menuservice.domain.banner.entity.Banner;

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

    private ArrayList<Menu> childs = new ArrayList<Menu>();

    @Builder
    public Menu(String id, String title, String link, String parentId, Banner banner, ArrayList<Menu> childs){
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.link = Objects.requireNonNull(link);
        this.parentId = parentId;
        this.banner = banner;
        this.childs = childs;
    }

    public void add(Menu menu){
        if(this.childs == null){
            this.childs = new ArrayList<>();
        }
        
        this.childs.add(menu);
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
