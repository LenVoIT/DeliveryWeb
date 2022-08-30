package com.nhpvtl.pojo;

import com.nhpvtl.pojo.OrdersDetail;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, String> discountName;
    public static volatile SingularAttribute<Discount, Integer> discountPercent;
    public static volatile SetAttribute<Discount, OrdersDetail> ordersDetailSet;
    public static volatile SingularAttribute<Discount, Integer> id;

}