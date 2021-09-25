package com.tharuke.lhi.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Order extends PersistObject{

    private int orderNumber;
    private Customer customer;
    private List<Part> itemList;
    private int discount;
    private double subTotal;
    private double total;


}
