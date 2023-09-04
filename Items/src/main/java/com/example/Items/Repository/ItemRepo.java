package com.example.Items.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Items.Entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
    
}
