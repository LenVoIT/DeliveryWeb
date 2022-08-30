package com.nhpvtl.pojo;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.Place;
import com.nhpvtl.pojo.Shipper;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SetAttribute<City, Shipper> shipperSet;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SetAttribute<City, Place> placeSet;
    public static volatile SingularAttribute<City, Integer> id;
    public static volatile SetAttribute<City, Orders> ordersSet;

}