package com.musinsa.menuservice.domain.menu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musinsa.menuservice.domain.menu.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, String>{
    
}
