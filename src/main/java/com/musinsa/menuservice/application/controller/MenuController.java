package com.musinsa.menuservice.application.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.dto.RegisterMenuCommand;
import com.musinsa.menuservice.domain.menu.service.MenuReadService;
import com.musinsa.menuservice.domain.menu.service.MenuWriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuWriteService menuWriteService;

    @PostMapping("/menus")
    public ResponseEntity<MenuDto> createMenu(@RequestBody RegisterMenuCommand command) {
        MenuDto menuDto = menuWriteService.create(command);
        return ResponseEntity.created(URI.create("/menus/")).body(menuDto);
    }
}
