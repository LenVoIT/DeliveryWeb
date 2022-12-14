/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.UserAccount;
import com.nhpvtl.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<UserAccount> getAccounts(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<UserAccount> q = b.createQuery(UserAccount.class);
        Root root = q.from(UserAccount.class);
        q.select(root);

        Query query = s.createQuery(q);
        if (page > 0) {
            int size = 0;
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

}
