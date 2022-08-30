/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhpvtl.repository.impl;

import com.nhpvtl.pojo.Orders;
import com.nhpvtl.repository.OrderShipRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class OrderShipRepositoryImpl implements OrderShipRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Orders> getOrders(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Orders> q = b.createQuery(Orders.class);
        Root root = q.from(Orders.class);
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

    @Override
    public Orders getById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Orders.class, id);
    }

    @Override
    public boolean addOrUpdate(Orders orders) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (orders.getId() > 0)
                session.update(orders);
            else
                session.save(orders);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int countOrders() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Orders ");

        return Integer.parseInt(q.getSingleResult().toString());
    }

}
