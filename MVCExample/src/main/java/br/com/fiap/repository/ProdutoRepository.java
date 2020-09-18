package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}