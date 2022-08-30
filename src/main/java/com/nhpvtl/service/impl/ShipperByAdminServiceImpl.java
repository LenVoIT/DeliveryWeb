/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.service.impl;

import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperByAdminRepository;
import com.nhpvtl.service.ShipperByAdminService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ShipperByAdminServiceImpl implements ShipperByAdminService {

    @Autowired
    private ShipperByAdminRepository shipperByAdminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Autowired
//    private Cloudinary cloudinary;
    @Override
    public UserAccount getById(int id) {
        return this.shipperByAdminRepository.getById(id);
    }

    @Override
    public boolean addOrUpdate(UserAccount user) {
        String pass = user.getUserPassword();
        user.setUserPassword(this.passwordEncoder.encode(pass));

//        String avatar = user.getAvatar();
//
//        if (!user.getFile().isEmpty()) {
//            Map r = null;
//            try {
//                r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
//                        ObjectUtils.asMap("resource_type", "auto"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if (r != null) {
//                user.setAvatar((String) r.get("secure_url"));
//            } else {
//                user.setAvatar(avatar);
//            }
//        }
        return this.shipperByAdminRepository.addOrUpdate(user);
    }

    @Override
    public UserAccount getByUsername(String username) {
        return this.shipperByAdminRepository.getByUsername(username);
    }

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        return this.shipperByAdminRepository.getAccounts(params, page);
    }

    @Override
    public List<UserAccount> getByRole(String role, int page, int active) {
        return this.shipperByAdminRepository.getByRole(role, page, active);
    }

    @Override
    public List<UserAccount> getUsers(String username, int page) {
        return this.shipperByAdminRepository.getUsers(username, page);
    }

    @Override
    public List<UserAccount> getUsersMultiCondition(Map<String, String> params, int page) {
        return this.shipperByAdminRepository.getUsersMultiCondition(params, page);
    }

    @Override
    public List<UserAccount> getByGmail(String gmail) {
        return this.shipperByAdminRepository.getByGmail(gmail);
    }

    @Override
    public List<UserAccount> getByPhonenumber(String phonenumber) {
        return this.shipperByAdminRepository.getByPhonenumber(phonenumber);
    }

    @Override
    public boolean delete(UserAccount user) {
        return this.shipperByAdminRepository.delete(user);
    }

    @Override
    public long count() {
        return this.shipperByAdminRepository.count();
    }

    @Override
    public int getMaxItemsInPage() {
        return this.getMaxItemsInPage();
    }

    @Override
    public int countAccount() {
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserAccount> accounts = this.getUsers(username, 0);
        if (accounts.isEmpty()) {
            throw new UsernameNotFoundException("User does not exist!!!");
        }

        UserAccount account = accounts.get(0);

        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(account.getUserRole()));

        return new org.springframework.security.core.userdetails.User(account.getUserName(), account.getUserPassword(), auth);
    }

    @Override
    public List<UserAccount> getAccounts(String kw, int page) {
        return this.shipperByAdminRepository.getAccounts(kw, page);
    }

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        return this.shipperByAdminRepository.getShippers(params, page);
    }
}
