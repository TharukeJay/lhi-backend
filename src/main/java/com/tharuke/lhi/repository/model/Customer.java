package com.tharuke.lhi.repository.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Customer extends PersistObject{

    private String customerName;
    private String address;
    private String customerId;
    private String contactNumber;
    private String town;
}
