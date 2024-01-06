package com.example.application.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.internal.icu.text.UnicodeSet;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "application_user")
public class User extends AbstractEntity {

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

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private Role role;
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    private Contract contract = null;
    public Contract getContract() { return contract; }
    public void setContract(Contract contract) { this.contract = contract; }

    @JsonIgnore
    private String hashedPassword;
    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    /*
    @Lob
    @Column(length = 1000000)
    private byte[] profilePicture;
    public byte[] getProfilePicture() { return profilePicture; }
    public void setProfilePicture(byte[] profilePicture) {  this.profilePicture = profilePicture; }
    */
    public User(String name,  Role role, Contract contract, String hashedPassword/*, byte[] profilePicture*/) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.role = role;
        this.contract = contract;
        this.hashedPassword = hashedPassword;
        /*
        this.profilePicture = profilePicture;*/
    }
}
