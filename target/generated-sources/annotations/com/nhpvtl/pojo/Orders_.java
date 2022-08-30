package com.nhpvtl.pojo;

import com.nhpvtl.pojo.City;
import com.nhpvtl.pojo.Customer;
import com.nhpvtl.pojo.OrdersDetail;
import com.nhpvtl.pojo.Shipper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Shipper> shipperId;
    public static volatile SingularAttribute<Orders, Date> requiredDate;
    public static volatile SingularAttribute<Orders, City> cityId;
    public static volatile SingularAttribute<Orders, String> shipName;
    public static volatile SingularAttribute<Orders, String> shipAddress;
    public static volatile SingularAttribute<Orders, Integer> shipPostalcode;
    public static volatile SetAttribute<Orders, OrdersDetail> ordersDetailSet;
    public static volatile SingularAttribute<Orders, Customer> customerId;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Boolean> shipStatus;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, Date> shippedDate;
    public static volatile SingularAttribute<Orders, Boolean> paymentStatus;

}