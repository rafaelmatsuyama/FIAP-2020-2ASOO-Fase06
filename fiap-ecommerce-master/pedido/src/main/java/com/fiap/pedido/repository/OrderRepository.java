package com.fiap.pedido.repository;

import com.fiap.pedido.domain.Order;
import com.fiap.pedido.domain.Status;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    Order findByIdAndStatus(final long id, Status processed);
}
