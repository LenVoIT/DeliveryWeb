/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface ShipperByAdminService extends UserDetailsService{
    
    UserAccount getById(int id);

    boolean addOrUpdate(UserAccount user);

    UserAccount getByUsername(String username);

    List<UserAccount> getAccounts(Map<String, String> params, int page);

    List<UserAccount> getByRole(String role, int page, int active);

    List<UserAccount> getUsers(String username, int page);

    List<UserAccount> getUsersMultiCondition(Map<String, String> params, int page);

    List<UserAccount> getByGmail(String gmail);

    List<UserAccount> getByPhonenumber(String phonenumber);

    boolean delete(UserAccount user);

    long count();

    int getMaxItemsInPage();
    
    int countAccount();
    
    List<UserAccount> getAccounts(String kw, int page);
    
    List<Shipper> getShippers(Map<String, String> params, int page);
}
