package com.fiap.estoque.repository;

import com.fiap.estoque.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
