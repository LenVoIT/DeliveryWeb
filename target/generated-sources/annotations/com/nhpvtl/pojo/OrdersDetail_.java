package com.nhpvtl.pojo;

import com.nhpvtl.pojo.Discount;
import com.nhpvtl.pojo.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(OrdersDetail.class)
public class OrdersDetail_ { 

    public static volatile SingularAttribute<OrdersDetail, Orders> orderId;
    public static volatile SingularAttribute<OrdersDetail, Boolean> orderStatus;
    public static volatile SingularAttribute<OrdersDetail, Integer> id;
    public static volatile SingularAttribute<OrdersDetail, Long> shipPrice;
    public static volatile SingularAttribute<OrdersDetail, Discount> discountId;
    public static volatile SingularAttribute<OrdersDetail, String> productName;

}