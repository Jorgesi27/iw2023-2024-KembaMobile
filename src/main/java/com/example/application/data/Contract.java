package com.example.application.data;

import jakarta.persistence.*;
import jdk.internal.icu.text.UnicodeSet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "contract")
public class Contract extends AbstractEntity {

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

    private User user;
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    private List<Service> hiredServices;
    public List<Service> getHiredServices() { return hiredServices; }
    public void setHiredServices(List<Service> hiredServices) { this.hiredServices = hiredServices; }

    public Contract(User user, List<Service> hiredServices) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.hiredServices = hiredServices;
    }
}
