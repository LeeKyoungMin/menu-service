package com.musinsa.menuservice.domain.banner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Banner {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String imageUrl;

    private String linkUrl;

    @Builder
    public Banner(String id, String imageUrl, String linkUrl){
        this.id = id;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
    }
}
