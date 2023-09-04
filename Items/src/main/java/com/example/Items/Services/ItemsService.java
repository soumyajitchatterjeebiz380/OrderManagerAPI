package com.example.Items.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Items.Entity.Item;
import com.example.Items.Repository.ItemRepo;

@Service
public class ItemsService {
    @Autowired
    ItemRepo ir;

    public List<Item> retreiveItems() {
        List<Item> retList = new ArrayList<>();
        ir.findAll().forEach(item -> retList.add(item));
        return retList;
    }

    public String insertItem(Item item) {
        ir.save(item);
        return "Saved Item";
    }

    public String updateItem(Item item) {
        Item extract = ir.findById(item.getItem_id()).orElse(null);
        if(extract == null) return "Item does not exist";
        extract.setQuantity(item.getQuantity());
        extract.setReview(item.getQuantity());
        ir.save(extract);
        return "Item sucessfully updated";
    }

    public String deleteItem(Item item) {
        Item extract = ir.findById(item.getItem_id()).orElse(null);
        if(extract == null) return "Item does not exist. Delete Unsucessful";
        ir.deleteById(item.getItem_id());
        return "Item sucessfully deleted";
    }

    public Item getItemById(String itemid) {
        return ir.findById(itemid).orElse(null);
    }

    public void updateItemById(String itemid, int quantity) {
         Item extract = ir.findById(itemid).orElse(null);
         extract.setQuantity(extract.getQuantity() - quantity);
         ir.save(extract);
    }


}
