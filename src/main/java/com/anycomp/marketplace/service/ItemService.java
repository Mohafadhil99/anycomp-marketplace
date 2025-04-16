package com.anycomp.marketplace.service;

import com.anycomp.marketplace.entity.Item;
import com.anycomp.marketplace.entity.Seller;
import com.anycomp.marketplace.repository.ItemRepository;
import com.anycomp.marketplace.repository.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final SellerRepository sellerRepository;

    public ItemService(ItemRepository itemRepository, SellerRepository sellerRepository) {
        this.itemRepository = itemRepository;
        this.sellerRepository = sellerRepository;
    }

    public Page<Item> getAllItems(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow();
    }

    public java.util.List<Item> getItemsBySellerId(Long sellerId) {
        return itemRepository.findBySellerId(sellerId);
    }

    public Item addItemToSeller(Long sellerId, Item item) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow();
        item.setSeller(seller);
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElseThrow();
        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setPrice(itemDetails.getPrice());
        item.setQuantity(itemDetails.getQuantity());
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
