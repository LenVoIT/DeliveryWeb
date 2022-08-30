/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.pojo.Shipper;
import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.ShipperByAdminRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class ShipperByAdminRepositoryImpl implements ShipperByAdminRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    private final int maxItemsInPage = 10;

    @Override
    public UserAccount getById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(UserAccount.class, id);
    }

    @Override
    public boolean addOrUpdate(UserAccount user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (user.getId() > 0) {
                session.update(user);
            } else {
                session.save(user);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public UserAccount getByUsername(String username) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM UserAccount WHERE userName = :userName");
        q.setParameter("username", username);

        return (UserAccount) q.getSingleResult();
    }

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = b.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);
//        if (params != null) {
//            List<Predicate> predicates = new ArrayList<>();
//            String kw = params.get("kw");
//            if (kw != null && !kw.isEmpty()) {
//                Predicate p = b.like(root.get("userLastname").as(String.class), String.format("%%%s%%", kw));
//                q.where(p);
//            }
//
//            String us = params.get("username");
//            if (us != null) {
//                Predicate p = b.like(root.get("userName").as(String.class), us);
//                predicates.add(p);
//            }
//
//            String ad = params.get("useraddress");
//            if (ad != null) {
//                Predicate p = b.like(root.get("userAddress").as(String.class), ad);
//                predicates.add(p);
//            }
//
//            String gm = params.get("usergmail");
//            if (gm != null) {
//                Predicate p = b.like(root.get("userGmail").as(String.class), gm);
//                predicates.add(p);
//            }
//
//            String pq = params.get("loaitaikhoan");
//            if (pq != null) {
//                Predicate p = b.like(root.get("userRole").as(String.class), pq);
//                predicates.add(p);
//            }
//            q.where(predicates.toArray(Predicate[]::new));
//        }
        //org.hibernate.query.Query query = session.createQuery(q);
        Query query = session.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();
    }

    @Override
    public List<UserAccount> getByRole(String role, int page, int active) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
        Root root = query.from(UserAccount.class);
        query = query.select(root);

        Predicate p1 = builder.equal(root.get("userType").as(String.class), role.trim());
        Predicate p2 = builder.equal(root.get("active").as(Integer.class), active);

        query = query.where(p1, p2);

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        if (page != 0) {
            int max = maxItemsInPage;
            q.setMaxResults(max);
            q.setFirstResult((page - 1) * max);
        }
        return q.getResultList();
    }

    @Override
    public List<UserAccount> getUsers(String username, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
        Root root = query.from(UserAccount.class);
        query = query.select(root);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(root.get("userName").as(String.class), username.trim());
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        if (page != 0) {
            int max = maxItemsInPage;
            q.setMaxResults(max);
            q.setFirstResult((page - 1) * max);
        }
        return q.getResultList();
    }

    @Override
    public List<UserAccount> getUsersMultiCondition(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = builder.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);
        q = q.orderBy(builder.desc(root.get("id")));

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("userLastname")) {
                Predicate p1 = builder.like(root.get("userLastname").as(String.class),
                        String.format("%%%s%%", params.get("userLastname")));
                predicates.add(p1);
            }

            if (params.containsKey("userGender")) {
                Predicate p2 = builder.equal(root.get("userGender").as(String.class), params.get("userGender"));
                predicates.add(p2);
            }

            if (params.containsKey("userType")) {
                Predicate p3 = builder.equal(root.get("userType").as(String.class), params.get("userType"));
                predicates.add(p3);
            }

            if (params.containsKey("active")) {
                int activeStt = Integer.parseInt(params.get("active"));
                Predicate p4 = builder.equal(root.get("active").as(Integer.class), activeStt);
                predicates.add(p4);
            }

            if (params.containsKey("userAddress")) {
                Predicate p7 = builder.like(root.get("userAddress").as(String.class),
                        String.format("%%%s%%", params.get("userAddress").trim().toLowerCase()));
                predicates.add(p7);
            }

            if (params.containsKey("userName")) {
                Predicate p8 = builder.like(root.get("userName").as(String.class),
                        String.format("%%%s%%", params.get("userName")));
                predicates.add(p8);
            }

            if (params.containsKey("userPhonenumber")) {
                Predicate p9 = builder.like(root.get("userPhonenumber").as(String.class),
                        String.format("%%%s%%", params.get("userPhonenumber")));
                predicates.add(p9);
            }

            if (params.containsKey("userGmail")) {
                Predicate p10 = builder.like(root.get("userGmail").as(String.class),
                        String.format("%%%s%%", params.get("userGmail")));
                predicates.add(p10);
            }

            if (params.containsKey("userType")) {
                Predicate p11 = builder.like(root.get("userType").as(String.class),
                        String.format("%%%s%%", params.get("userType")));
                predicates.add(p11);
            }

            q = q.where(predicates.toArray(new Predicate[]{}));
        }

        Query query = session.createQuery(q);

        if (page != 0) {
            int max = maxItemsInPage;
            query.setMaxResults(max);
            query.setFirstResult((page - 1) * max);
        }
        return query.getResultList();
    }

    @Override
    public List<UserAccount> getByPhonenumber(String phonenumber) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
        Root root = query.from(UserAccount.class);
        query = query.select(root);

        if (!phonenumber.isEmpty()) {
            Predicate p = builder.equal(root.get("userPhonenumber").as(String.class), phonenumber.trim());
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public boolean delete(UserAccount user) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(user);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public long count() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From UserAccount");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public int getMaxItemsInPage() {
        return maxItemsInPage;
    }

    @Override
    public List<UserAccount> getByGmail(String gmail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> query = builder.createQuery(UserAccount.class);
        Root root = query.from(UserAccount.class);
        query = query.select(root);

        if (!gmail.isEmpty()) {
            Predicate p = builder.equal(root.get("userGmail").as(String.class), gmail.trim());
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));

        Query q = session.createQuery(query);

        return q.getResultList();
    }

    @Override
    public List<UserAccount> getAccounts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = b.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);

        if (kw != null) {
            Predicate p = b.like(root.get("userLastname").as(String.class),
                    String.format("%%%s%%", kw));
            q = q.where(p);
        }
        Query query = session.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }
        return query.getResultList();

    }

    @Override
    public List<Shipper> getShippers(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Shipper> q = b.createQuery(Shipper.class);
        Root root = q.from(Shipper.class);
        q.select(root);

        Query query = session.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);

        }
        return query.getResultList();
    }
}
