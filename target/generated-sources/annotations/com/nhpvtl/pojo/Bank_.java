package com.nhpvtl.pojo;

import com.nhpvtl.pojo.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Bank.class)
public class Bank_ { 

    public static volatile SetAttribute<Bank, Customer> customerSet;
    public static volatile SingularAttribute<Bank, String> bankName;
    public static volatile SingularAttribute<Bank, Integer> id;

}