package com.example.Items.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="items")
@Setter
@Getter
public class Item {
    @Id
    String item_id;
    int quantity;
    int review;
    int num_review;
}
