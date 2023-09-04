package com.example.Items.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Items.Entity.Item;
import com.example.Items.Services.ItemsService;

@RestController
public class ItemController {
    @Autowired
    ItemsService is;

    @GetMapping("/items")
    public List<Item> retreiveItems() {
        return is.retreiveItems();
    }

    @PostMapping("/items/item")
    public String insertNewItem(@RequestBody Item item) {
        return is.insertItem(item);
    }

    @PutMapping("/items/item")
    public String updateItem(@RequestBody Item item) {
        return is.updateItem(item);
    }

    @DeleteMapping("/items/item")
    public String deleteItem(@RequestBody Item item) {
        return is.deleteItem(item);
    }

    @GetMapping("items/item/{item}")
    public Item getItemByIdItem(@PathVariable String item) {
        return is.getItemById(item);
    }

    @PutMapping("items/item/{itemid}/{quantity}")
    public String updateItemBYId(@PathVariable String itemid, @PathVariable int quantity) {
        is.updateItemById(itemid, quantity);
        return "Successfully updated item";
    }   

}
