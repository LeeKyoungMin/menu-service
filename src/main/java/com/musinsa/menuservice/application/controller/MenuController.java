package com.musinsa.menuservice.application.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musinsa.menuservice.domain.menu.dto.MenuCommand;
import com.musinsa.menuservice.domain.menu.dto.MenuDto;
import com.musinsa.menuservice.domain.menu.service.MenuReadService;
import com.musinsa.menuservice.domain.menu.service.MenuWriteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class MenuController {
    private final MenuWriteService menuWriteService;
    private final MenuReadService menuReadService;

    @PostMapping("/menus")
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuCommand command) {
        var menuDto = menuWriteService.createMenu(command);
        return ResponseEntity.created(URI.create("/menus/")).body(menuDto);
    }

    @PutMapping(value="/menues/{id}")
    public ResponseEntity<Void> updateMenu(
        @PathVariable String id, 
        @RequestBody MenuCommand command
    ) {
        menuWriteService.updateMenu(id, command);        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/menus/{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable String id){
        var menuDto = menuReadService.getMenu(id);
        return ResponseEntity.ok(menuDto);
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto>> getMenus(){
        var menuDto = menuReadService.getMenus();
        return ResponseEntity.ok(menuDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String id) {
        menuWriteService.deleteMenu(id);
    }
}
