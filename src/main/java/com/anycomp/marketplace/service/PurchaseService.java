package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Buyer;
import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.entity.Purchase;
import com.anycomp.marketplace.repository.BuyerRepository;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final BuyerRepository buyerRepository;
    private final ItemRepository itemRepository;

    public PurchaseService(PurchaseRepository purchaseRepository, BuyerRepository buyerRepository, ItemRepository itemRepository) {
        this.purchaseRepository = purchaseRepository;
        this.buyerRepository = buyerRepository;
        this.itemRepository = itemRepository;
    }

    public Purchase purchaseItem(Long buyerId, Long itemId, int quantity) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();

        if (item.getQuantity() < quantity) {
            throw new RuntimeException("Not enough item stock available.");
        }

        item.setQuantity(item.getQuantity() - quantity);
        itemRepository.save(item);

        Purchase purchase = new Purchase();
        purchase.setBuyer(buyer);
        purchase.setItem(item);
        purchase.setQuantity(quantity);
        purchase.setPurchaseDate(new Timestamp(System.currentTimeMillis()));

        return purchaseRepository.save(purchase);
    }
}
