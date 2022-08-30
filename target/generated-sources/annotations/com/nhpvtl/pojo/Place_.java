package com.nhpvtl.pojo;

import com.nhpvtl.pojo.City;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(Place.class)
public class Place_ { 

    public static volatile SingularAttribute<Place, String> address;
    public static volatile SingularAttribute<Place, Integer> id;
    public static volatile SingularAttribute<Place, City> cityId;

}