package com.fiap.remessa.domain;

public enum StatusEnum {
    /**
     * Aguardando produtos chegaram para remessa.
     */
    WATING_PRODUCTS,

    /**
     * Empacotando produtos para envio.
     */
    PACKING,

    /**
     * Produtos enviado.
     */
    SHIPPED,

    /**
     * Remessa cancelada
     */
    CANCELED
}