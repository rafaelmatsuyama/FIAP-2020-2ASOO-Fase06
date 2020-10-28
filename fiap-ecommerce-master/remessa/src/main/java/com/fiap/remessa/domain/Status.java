package com.fiap.remessa.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    private String description;

    public Status() {
    }

    public Status(final Shipping shipping, final StatusEnum status, final String description) {
        this.shipping = shipping;
        this.status = status;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Status setId(final long id) {
        this.id = id;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public Status setStatus(final StatusEnum status) {
        this.status = status;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Status setShipping(final Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Status setDescription(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Status that = (Status) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(shipping, that.shipping) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, shipping, description);
    }

    @Override
    public String toString() {
        return "ShippingStatus{" +
                "id=" + id +
                ", status=" + status +
                ", shipping=" + shipping.getId() +
                ", description='" + description + '\'' +
                '}';
    }
}
