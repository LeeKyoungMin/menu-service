package com.musinsa.menuservice.domain.menu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Menu> childs = new ArrayList<Menu>();

    @Builder
    public Menu(String id, String title, String link, Menu parent, Banner banner, ArrayList<Menu> childs){
        this.id = id;
        this.title = Objects.requireNonNull(title);
        this.link = Objects.requireNonNull(link);
        this.parent = parent;
        this.banner = banner;
        this.childs = childs;
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
