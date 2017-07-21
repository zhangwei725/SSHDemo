package com.werner.webapp.dao;




import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("baseDao")
public class BaseDAOImpl<T, PK extends java.io.Serializable> implements BaseDAO<T, PK> {

    private static Log log;

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;


    public Log getLog() {
        if (null == log) {
            log = LogFactory.getLog(this.getClass());
        }
        return log;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public int save(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            getLog().error("保存对象发生异常:" + e.getMessage());
            return 0;
        }
        return 1;
    }

    @Transactional
    public int update(T entity) {
        try {
            entity = entityManager.merge(entity);
        } catch (Exception e) {
            getLog().error("获取对象发生异常:" + e.getMessage());
            return 0;
        }
        return 1;
    }

    @Transactional
    public int delete(T entity) {
        try {
            entityManager.remove(entityManager.merge(entity));
            return 1;
        } catch (Exception e) {
            getLog().error("删除对象发生异常:" + e.getMessage());
            return 0;
        }
    }

    @Transactional
    public int delete(PK id) {
        return this.delete(this.findById(id));
    }

    public T findById(PK id) {
        T entity = null;
        try {
            entity = entityManager.find(entityClass, id);
        } catch (Exception e) {
            getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return entity;
    }

    public List<T> findByQL(String queryString) {
        List<T> rList = new ArrayList<T>();
        try {
            rList = (List<T>) entityManager.createQuery(queryString).getResultList();
        } catch (Exception e) {
            getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<T> findByQL(String queryString, Map<String, Object> map) {
        List<T> rList = new ArrayList<T>();
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            rList = (List<T>) q.getResultList();
        } catch (Exception e) {
            getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<Object> findBySQL(String queryString) {
        List<Object> rList = new ArrayList<Object>();
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            rList = q.getResultList();
        } catch (Exception e) {
            this.getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<Object> findBySQL(String queryString, Map<String, Object> map) {
        List<Object> rList = new ArrayList<Object>();
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            rList = q.getResultList();
        } catch (Exception e) {
            this.getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<T> findByQL(String queryString, int maxSize, int firstId) {
        List<T> rList = new ArrayList<T>();
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            q.setMaxResults(maxSize);
            q.setFirstResult(firstId);
            rList = q.getResultList();
        } catch (Exception e) {
            this.getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<T> findByQL(String queryString, int maxSize, int firstId, Map<String, Object> map) {
        List<T> rList = new ArrayList<>();

        rList = getList(queryString, maxSize, firstId, map, rList);

        return rList;
    }

    public List<Object> findObjectByQL(String queryString, int maxSize, int firstId, Map<String, Object> map) {
        List<Object> rList = new ArrayList<>();
        rList = (List<Object>) getList(queryString, maxSize, firstId, map, (List<T>) rList);
        return rList;
    }

    private List<T> getList(String queryString, int maxSize, int firstId, Map<String, Object> map, List<T> rList) {
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            q.setMaxResults(maxSize);
            q.setFirstResult(firstId);
            rList = q.getResultList();
        } catch (Exception e) {
            this.getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }


    public List<Object> findBySQL(String queryString, int maxSize, int firstId) {
        List<Object> rList = new ArrayList<Object>();
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            q.setMaxResults(maxSize);
            q.setFirstResult(firstId);
            rList = q.getResultList();
        } catch (Exception e) {
            this.getLog().error("获取对象发生异常:" + e.getMessage());
        }
        return rList;
    }

    public List<Object> findBySQL(String queryString, int maxSize, int firstId, Map<String, Object> map) {
        List<Object> rList = new ArrayList<Object>();
        rList = (List<Object>) getList(queryString, maxSize, firstId, map, (List<T>) rList);
        return rList;
    }

    public int getCountByQL(String queryString) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            intCount = ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            getLog().error("获取对象总数发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    public int getCountByQL(String queryString, Map<String, Object> map) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            intCount = ((Long) q.getSingleResult()).intValue();

        } catch (Exception e) {
            getLog().error("获取对象总数发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    public int getCountBySQL(String queryString) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            intCount = ((Integer) q.getSingleResult()).intValue();
        } catch (Exception e) {
            getLog().error("获取对象总数发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    public int getCountBySQL(String queryString, Map<String, Object> map) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            intCount = ((Integer) q.getSingleResult()).intValue();
        } catch (Exception e) {
            getLog().error("获取对象总数发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    public int getCountBySQL2(String queryString, Map<String, Object> map) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            String str = q.getSingleResult().toString();
            intCount = Integer.parseInt(str);
        } catch (Exception e) {
            getLog().error("获取对象总数发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    @Transactional
    public int executeUpdateByQL(String queryString) {
        int intCount = 0;
        try {
            intCount = this.getEntityManager().createQuery(queryString).executeUpdate();
        } catch (Exception e) {
            getLog().error("执行更新语句发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    @Transactional
    public int executeUpdateByQL(String queryString, Map<String, Object> map) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            intCount = q.executeUpdate();
        } catch (Exception e) {
            getLog().error("执行更新语句发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    @Transactional
    public int executeUpdateBySQL(String queryString) {
        int intCount = 0;
        try {
            intCount = this.getEntityManager().createNativeQuery(queryString).executeUpdate();
        } catch (Exception e) {
            getLog().error("执行更新语句发生异常:" + e.getMessage());
        }
        return intCount;
    }

    @Transactional
    public int executeUpdateBySQL(String queryString, Map<String, Object> map) {
        int intCount = 0;
        try {
            Query q = this.getEntityManager().createNativeQuery(queryString);
            if (null != map) {
                for (String key : map.keySet()) {
                    q.setParameter(key, map.get(key));
                }
            }
            intCount = q.executeUpdate();
        } catch (Exception e) {
            getLog().error("执行更新语句发生异常:" + e.getMessage());
            e.printStackTrace();
        }
        return intCount;
    }

    @Override
    public boolean executeTransactionalByQL(List<QueryParameter> queryParameterList) {
//        if (null == queryParameterList || queryParameterList.isEmpty()) {
//            return false;
//        }
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            for (QueryParameter queryParameter : queryParameterList) {
//                Query query;
//                if (queryParameter.getParameterName().contains(QueryParameter.PARAM_KEY_INSETER)
//                        ||queryParameter.getParameterType() == "SQL"){
//
//                }
//
//                if (StringUtils.indexOf(queryParameter.getParameterName(), QueryParameter.PARAMRS_KEY_INSETER) >= 0 || ) {
//                    query = entityManager.createNativeQuery(queryParameter.getQueryString());
//                    query.unwrap(NativeQuery.class).setResultTransformer(Transformers.aliasToBean());
//                } else {
//                    query = entityManager.createQuery(queryParameter.getQueryString());
//                }
//                if (null != queryParameter.getParameterMap()) {
//                    for (String key : queryParameter.getParameterMap().keySet()) {
//                        query.setParameter(key, queryParameter.getParameterMap().get(key));
//                    }
//                }
//                query.executeUpdate();
//            }
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            getLog().error("执行事务发生异常:" + e.getMessage());
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//            return false;
//        } finally {
//            entityManager.close();
//        }
        return true;
    }

    @Override
    public boolean executeTransactionalBySQL(List<QueryParameter> queryParameterList) {
//        if (null == queryParameterList || queryParameterList.isEmpty()) {
//            return false;
//        }
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        try {
//            entityManager.getTransaction().begin();
//            for (QueryParameter queryParameter : queryParameterList) {
//                Query q = entityManager.createNativeQuery(queryParameter.getQueryString());
//                if (null != queryParameter.getParameterMap()) {
//                    for (String key : queryParameter.getParameterMap().keySet()) {
//                        q.setParameter(key, queryParameter.getParameterMap().get(key));
//                    }
//                }
//                q.executeUpdate();
//            }
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            getLog().error("执行事务发生异常:" + e.getMessage());
//            entityManager.getTransaction().rollback();
//            e.printStackTrace();
//            return false;
//        } finally {
//            entityManager.close();
//        }
        return true;
    }
}
