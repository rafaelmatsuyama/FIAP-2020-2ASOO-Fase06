package com.fiap.remessa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private String address;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "shipping"
    )
    private List<Status> status;

    public Shipping() {
    }

    public Shipping(final long userId, final String address, final List<Status>status) {
        this.userId = userId;
        this.address = address;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Shipping setId(final long id) {
        this.id = id;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public Shipping setUserId(final long userId) {
        this.userId = userId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Shipping setAddress(final String address) {
        this.address = address;
        return this;
    }

    public Status getLastStatus() {
        if (this.getStatus().isEmpty()) {
            return null;
        }

        return this.getStatus().get(this.getStatus().size() - 1);
    }


    public List<Status> getStatus() {
        return status;
    }

    public Shipping setStatus(final List<Status> status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Shipping shipping = (Shipping) o;
        return id == shipping.id &&
                userId == shipping.userId &&
                Objects.equals(address, shipping.address) &&
                Objects.equals(status, shipping.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, address, status);
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
