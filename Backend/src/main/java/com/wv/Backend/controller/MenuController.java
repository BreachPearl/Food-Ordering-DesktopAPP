package com.wv.Backend.controller;

import com.wv.Backend.model.FoodItem;
import com.wv.Backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private FoodItemRepository repository;

    @GetMapping
    public List<FoodItem> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public FoodItem addItem(@RequestBody FoodItem item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public FoodItem updateItem(@PathVariable Long id, @RequestBody FoodItem updatedItem) {
        FoodItem existingItem = repository.findById(id).orElseThrow();
        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setPrice(updatedItem.getPrice());
        existingItem.setAvailable(updatedItem.isAvailable());
        return repository.save(existingItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
