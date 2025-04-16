package com.anycomp.marketplace.controller;

import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Page<Item> getAllItems(Pageable pageable) {
        return itemService.getAllItems(pageable);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/seller/{sellerId}")
    public List<Item> getItemsBySeller(@PathVariable Long sellerId) {
        return itemService.getItemsBySellerId(sellerId);
    }

    @PostMapping("/seller/{sellerId}")
    public Item addItemToSeller(@PathVariable Long sellerId, @RequestBody Item item) {
        return itemService.addItemToSeller(sellerId, item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
