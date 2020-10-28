package com.fiap.estoque.service;

import com.fiap.estoque.domain.Item;
import com.fiap.estoque.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class EstoqueService {

    private final ItemRepository productRepository;

    @Autowired
    public EstoqueService(final ItemRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Iterable<Item> addItem(long productId, int quantity) {
        final ArrayList<Item> products = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            products.add(new Item(productId,
                    BigDecimal.valueOf(12345),
                    10
            ));
        }

        return productRepository.saveAll(products);
    }

    public Page<Item> getAllItems() {
        return productRepository.findAll(PageRequest.of(0, 3));
    }


    public void remove(Item item, int quantity) {
        item.setQuantity(item.getQuantity() - quantity);
        Assert.isTrue(item.getQuantity() >= 0, "Este item não está disponível em estoque.");
        productRepository.save(item);
    }
}
