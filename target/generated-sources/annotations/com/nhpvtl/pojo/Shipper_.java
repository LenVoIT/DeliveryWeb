package com.nhpvtl.pojo;

import com.nhpvtl.pojo.City;
import com.nhpvtl.pojo.Feedback;
import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.UserAccount;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Shipper.class)
public class Shipper_ { 

    public static volatile SingularAttribute<Shipper, UserAccount> accountId;
    public static volatile SingularAttribute<Shipper, String> licensePlate;
    public static volatile SetAttribute<Shipper, Feedback> feedbackSet;
    public static volatile SingularAttribute<Shipper, Integer> id;
    public static volatile SingularAttribute<Shipper, City> cityId;
    public static volatile SetAttribute<Shipper, Orders> ordersSet;
    public static volatile SingularAttribute<Shipper, String> avatarShipper;

}