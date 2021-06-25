package com.globant.bootcamp.shoppingcart.model;

import java.time.LocalDate;

public class Product {

    private int id;
    private String description;
    private LocalDate expiresIn;
    private String lote;

    public Product(int id, String description, LocalDate expiresIn, String lote){
        this.id = id;
        this.description = description;
        this.expiresIn = expiresIn;
        this.lote = lote;
    }

    public int getId() {
        return id;
    }

    public LocalDate getExpiresIn() {
        return expiresIn;
    }

    public String getDescription() {
        return description;
    }

    public String getLote() {
        return lote;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExpiresIn(LocalDate expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
