package com.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//annotions for allargs constructor, noargs constructor, getter, setter, tostring
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//annotions for component and scope
@Component("customer")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Customer {
    
    private int customerId;
    private String customerName;
    @Autowired
    private Address address;
    @Autowired
    private MyDate dateOfBirth;
}
