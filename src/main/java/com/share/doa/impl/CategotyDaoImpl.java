package com.share.doa.impl;

import com.share.doa.CategoryDao;
import com.share.domain.Category;
import com.share.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public class CategotyDaoImpl implements CategoryDao{

    private static final Logger logger = Logger.getLogger(CategotyDaoImpl.class);

    public Category add(Category category) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction= session.beginTransaction();

        logger.debug("CategotyDaoImpl: add: " + category);

        session.save(category);
        session.flush();
        transaction.commit();
        return category;
    }

    public Category findById(int categoryId) {
        logger.debug("CategotyDaoImpl: findById: " + categoryId);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        try {
            Category category = (Category)session.createQuery("from Category where id = " + categoryId).list().get(0);
            transaction.commit();

            logger.debug("CategotyDaoImpl: Category: " + category);
            return category;
        } catch (IndexOutOfBoundsException ex){
            logger.warn("CategotyDaoImpl: null: " + ex);
            return null;
        }
    }

    public void update(Category category) {
        logger.debug("CategotyDaoImpl: update: " + category);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sess = sessionFactory.getCurrentSession();

        Transaction tx = sess.beginTransaction();
        sess.update(category);
        tx.commit();
    }


    public Set<Category> getAll() {
        logger.debug("CategotyDaoImpl: getAll");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        List<Category> list = session.createQuery("from Category").list();
        Set<Category> categories = new HashSet<Category>(list);
        transaction.commit();

        return categories;
    }

}
