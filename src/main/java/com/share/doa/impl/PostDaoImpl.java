package com.share.doa.impl;

import com.share.doa.PostDao;
import com.share.domain.Post;
import com.share.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mix on 20.03.2016.
 */
public class PostDaoImpl implements PostDao{

    private static final Logger logger = Logger.getLogger(PostDaoImpl.class);

    public Post add(Post post) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        logger.debug("PostDaoImpl: add: " + post);

        Transaction transaction= session.beginTransaction();
        session.save(post);
        session.flush();
        transaction.commit();
        return post;
    }

    public void update(Post post) {
        logger.debug("PostDaoImpl: update: " + post);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session sess = sessionFactory.getCurrentSession();

        Transaction tx = sess.beginTransaction();
        sess.update(post);
        tx.commit();
    }

    public Set<Post> getAll() {
        logger.debug("PostDaoImpl: getAll");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();

        List<Post> list = session.createQuery("from Post").list();
        Set<Post> posts = new HashSet<Post>(list);
        transaction.commit();

        return posts;
    }


}
