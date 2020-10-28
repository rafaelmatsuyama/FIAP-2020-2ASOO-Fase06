package com.fiap.remessa.repository;

import com.fiap.remessa.domain.Shipping;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends PagingAndSortingRepository<Shipping, Long> {
    Shipping findByUserId(final long userId);
}
