package com.fiap.estoque;

import com.fiap.estoque.domain.Item;
import com.fiap.estoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

@SpringBootApplication
public class EstoqueApplication implements CommandLineRunner {

    @Autowired
    private EstoqueService estoqueService;

    public static void main(String[] args) {
        SpringApplication.run(EstoqueApplication.class, args);
    }

    @Override
    public void run(String... args) {
        line();
        System.out.println("EstoqueApplication.run");

        System.out.println("Itens criados:");
        System.out.println(estoqueService.addItem(1L, 10));

        System.out.println("Todos os itens em estoque:");
        final Page<Item> allProducts = estoqueService.getAllItems();
        System.out.println(allProducts);

        System.out.println("Primeiro Item:");
        final Item firstProduct = allProducts.get().findFirst().get();
        System.out.println(firstProduct);

        System.out.println("Dar baixa em um item do estoque");
        for (int i = 0; i < 5; i++) {
            estoqueService.remove(firstProduct, 1);
        }
        line();
    }

    private void line() {
        System.out.println();
        System.out.println("==============================");
        System.out.println();
    }
}