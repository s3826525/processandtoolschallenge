package com.rmit.assignment.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmit.assignment.dao.ItemDao;
import com.rmit.assignment.models.Item;
import com.rmit.assignment.service.ItemService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Validated
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public Optional<Item> getItem(ItemDao itemDao) {
        return itemService.getItem(itemDao);
    }

    @GetMapping("/item")
    public List<Item> getItemList() {
        return itemService.getItemList();
    }

    @PutMapping(value = "/item")
    public Item updateItem(ItemDao itemDao) {
        return itemService.updateItem(itemDao);
    }

    @DeleteMapping(value = "/item")
    public Item deleteItem(ItemDao itemDao) {
        return itemService.deleteItem(itemDao);
    }

}
