package com.nhpvtl.pojo;

import com.nhpvtl.pojo.Bank;
import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.UserAccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, Integer> bankNumber;
    public static volatile SingularAttribute<Customer, UserAccount> accountId;
    public static volatile SingularAttribute<Customer, Bank> bankId;
    public static volatile SetAttribute<Customer, Feedback> feedbackSet;
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SetAttribute<Customer, Orders> ordersSet;
    public static volatile SingularAttribute<Customer, String> avatarCustomer;

}