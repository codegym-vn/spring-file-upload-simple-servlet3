package com.codegym.file.repository;

import com.codegym.file.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }
}
