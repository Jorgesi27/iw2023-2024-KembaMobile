package com.example.application.data;

import jakarta.persistence.*;
import jdk.internal.icu.text.UnicodeSet;

import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "service")
public class Service extends AbstractEntity {

    private UUID id;
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    @Override
    public UnicodeSet getServicesContracted() {
        return null;
    }

    @Override
    public Optional<Object> getRoles() {
        return Optional.empty();
    }

    private String type; // fibra, movil, fijo o combinados.
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    private double price;
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Service(String type, double price) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.price = price;
    }
}
