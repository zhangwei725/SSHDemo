package com.werner.webapp.base;


import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract interface HibernateHandler extends Serializable {
    public abstract Object doInJPA(EntityManager entityManager);
}  