package com.anycomp.marketplace.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String name;
    private String description;
    private double price;
    private int quantity;
}
