package com.xjtu.power.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @Author: Jay
 * @Date: Created in 19:50 2018/12/26
 * @Modified By:
 */
@Data
public class Seller {

    @NonNull
    private int sellerID;

    private String name;

    private double quantity;

    private double price;

    private double maxQuantity;

    private double finalQuantity;

    private double finalPrice;

    public Seller(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+":price-"+price;
    }
}
