package com.fiap.pedido.domain;

public enum Status {
    /**
     * O pedido acabou de ser criado e vai se comunicar com outros processo para os próximos passos.
     */
    CREATED,

    /**
     * O pedido foi processado com sucesso. Todas as dependências foram executadas.
     */
    PROCESSED,

    /**
     * O pedido foi finalizado com sucesso.
     */
    COMPLETED,

    /**
     * O pedido foi cancelado.
     */
    CANCELED
}
