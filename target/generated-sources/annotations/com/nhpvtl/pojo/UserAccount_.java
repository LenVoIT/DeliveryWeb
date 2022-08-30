package com.nhpvtl.pojo;

import com.nhpvtl.pojo.Customer;
import com.nhpvtl.pojo.Shipper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-08-31T01:21:37")
@StaticMetamodel(UserAccount.class)
public class UserAccount_ { 

    public static volatile SingularAttribute<UserAccount, String> userPassword;
    public static volatile SetAttribute<UserAccount, Shipper> shipperSet;
    public static volatile SetAttribute<UserAccount, Customer> customerSet;
    public static volatile SingularAttribute<UserAccount, String> userLastname;
    public static volatile SingularAttribute<UserAccount, String> userAvatar;
    public static volatile SingularAttribute<UserAccount, String> userName;
    public static volatile SingularAttribute<UserAccount, String> userAddress;
    public static volatile SingularAttribute<UserAccount, Boolean> userActive;
    public static volatile SingularAttribute<UserAccount, Integer> userPhonenumber;
    public static volatile SingularAttribute<UserAccount, Date> userDateofbirth;
    public static volatile SingularAttribute<UserAccount, String> userGmail;
    public static volatile SingularAttribute<UserAccount, String> userFirstname;
    public static volatile SingularAttribute<UserAccount, String> userGender;
    public static volatile SingularAttribute<UserAccount, Integer> id;
    public static volatile SingularAttribute<UserAccount, String> userRole;
    public static volatile SingularAttribute<UserAccount, Integer> userCitizenidentitycard;

}