package com.fiap.remessa.service;

import com.fiap.remessa.domain.Shipping;
import com.fiap.remessa.domain.Status;
import com.fiap.remessa.domain.StatusEnum;
import com.fiap.remessa.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;

    @Autowired
    public ShippingService(final ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Transactional
    public Shipping startShipping(final long userId) {

        final Shipping shipping = new Shipping(
                userId,
                "User Addres, 123 - SP, Brasil",
                new ArrayList<>(1)
        );

        final Status status = createFirstShippingStatus(shipping);

        shipping.getStatus().add(status);

        return shippingRepository.save(shipping);
    }

    private Status createFirstShippingStatus(final Shipping shipping) {
        return new Status(
                shipping,
                StatusEnum.WATING_PRODUCTS,
                "Preparando para entrega"
        );
    }

    public void changeStatus(final Shipping shipping, final StatusEnum nextStatus, final String description) {
        final Status status = new Status(shipping, nextStatus, description);
        shipping.getStatus().add(status);
        shippingRepository.save(shipping);
    }

    public Shipping getLastShippingFrom(final long userId) {
        return shippingRepository.findByUserId(userId);
    }
}
