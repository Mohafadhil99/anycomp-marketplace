package com.anycomp.marketplace.dto;

import lombok.Data;

@Data
public class PurchaseRequest {
    private Long buyerId;
    private Long itemId;
    private int quantity;
}
