package com.fiap.remessa;

import com.fiap.remessa.domain.Shipping;
import com.fiap.remessa.domain.StatusEnum;
import com.fiap.remessa.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemessaApplication implements CommandLineRunner {

    @Autowired
    private ShippingService shippingService;

    public static void main(String[] args) {
        SpringApplication.run(RemessaApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        line();
        System.out.println("RemessaApplication.run");

		final long userId = 123L;
		final Shipping shipping = shippingService.startShipping(userId);
        System.out.println(shipping);

        System.out.println("Movendo os status da remessa:");
		shippingService.changeStatus(shipping, StatusEnum.PACKING, "Os produtos chegaram. Estamos empacotando.");
		shippingService.changeStatus(shipping, StatusEnum.SHIPPED, "Os produtos foram entregue");

		final Shipping lastShippingFrom = shippingService.getLastShippingFrom(userId);
        System.out.println(lastShippingFrom);
		line();
	}

    private void line() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println();
    }
}
