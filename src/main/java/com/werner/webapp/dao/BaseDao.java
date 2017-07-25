package com.werner.webapp.dao;


import java.util.List;
import java.util.Map;


public interface BaseDao<T, PK extends java.io.Serializable> {

    /**
     * 保存对象
     *
     * @param entity 实体
     * @return 1：操作成功 0：操作失败
     */
   public int save(T entity);

    /**
     * 保存多个对象信息
     *
     * @param entities 实体
     * @return 1：操作成功 0：操作失败
     */
    public int batchInsertAndUpdate(List<T> entities);

    public void saveOrUpdate(T entity);

    /**
     * 删除对象
     *
     * @param entity 实体
     * @return >0：操作成功
     */
    public int delete(T entity);

    /**
     * 删除对象
     *
     * @param id 主键
     * @return >0：操作成功
     */
    public int delete(PK id);

    /**
     * 根据ID获取实体对象
     *
     * @param id ID主键
     * @return 实体
     */
    public T findById(PK id);

    /**
     * 根据EJB-QL查询对象
     *
     * @param queryString QL语句
     * @return 数据集合
     */
    public List<T> findByQL(String queryString);

    /**
     * 根据EJB-QL查询对象
     *
     * @param queryString QL语句
     * @param map         参数
     * @return 数据集合
     */
    public List<T> findByQL(String queryString, Map<String, Object> map);

    /**
     * 根据SQL查询对象
     *
     * @param queryString SQL语句
     * @return 数据集合
     */
    public List<Object> findBySQL(String queryString);

    /**
     * 根据SQL查询对象
     *
     * @param queryString SQL语句
     * @param map         参数
     * @return 数据集合
     */
    public List<Object> findBySQL(String queryString, Map<String, Object> map);

    /**
     * 根据EJB-QL返回对象记录数
     *
     * @param queryString EJ-QL语句
     * @return 总记录数
     */
    public int getCountByQL(String queryString);

    /**
     * 根据EJB-QL返回对象记录数
     *
     * @param queryString EJ-QL语句
     * @param map         参数
     * @return 总记录数
     */
    public int getCountByQL(String queryString, Map<String, Object> map);

    /**
     * 根据SQL返回对象记录数
     *
     * @param queryString SQL语句
     * @return 总记录数
     */
    public int getCountBySQL(String queryString);

    /**
     * 根据SQL返回对象记录数
     *
     * @param queryString SQL语句
     * @param map         参数
     * @return 总记录数
     */
    public int getCountBySQL(String queryString, Map<String, Object> map);

    /**
     * 根据SQL返回对象记录数
     *
     * @param queryString SQL语句
     * @param map         参数
     * @return 总记录数
     */
    public int getCountBySQL2(String queryString, Map<String, Object> map);

    /**
     * 根据EJB-QL查询对象
     *
     * @param queryString QL语句
     * @param maxSize     最大数量
     * @param firstId     第一条记录
     * @return 数据集合
     */
    public List<T> findByQL(String queryString, int maxSize, int firstId);

    /**
     * 根据EJB-QL查询对象
     *
     * @param queryString QL语句
     * @param maxSize     最大数量
     * @param firstId     第一条记录
     * @param map         参数
     * @return 数据集合
     */
    public List<T> findByQL(String queryString, int maxSize, int firstId, Map<String, Object> map);

    /**
     * 根据SQL查询对象
     *
     * @param queryString SQL语句
     * @param maxSize     最大数量
     * @param firstId     第一条记录
     * @return 数据集合
     */
    public List<Object> findBySQL(String queryString, int maxSize, int firstId);

    /**
     * 根据SQL查询对象
     *
     * @param queryString SQL语句
     * @param maxSize     最大数量
     * @param firstId     第一条记录
     * @param map         参数
     * @return 数据集合
     */
    public List<Object> findBySQL(String queryString, int maxSize, int firstId, Map<String, Object> map);

    /**
     * 执行更新语句
     *
     * @param queryString EJ-QL语句
     * @return 影响记录数
     */
    public int executeUpdateByQL(String queryString);

    /**
     * 执行更新语句
     *
     * @param queryString EJ-QL语句
     * @param map         参数
     * @return 影响记录数
     */
    public int executeUpdateByQL(String queryString, Map<String, Object> map);

    /**
     * 执行更新语句
     *
     * @param queryString SQL语句
     * @return 影响记录数
     */
    public int executeUpdateBySQL(String queryString);

    /**
     * 执行更新语句
     *
     * @param queryString SQL语句
     * @param map         参数
     * @return 影响记录数
     */
    public int executeUpdateBySQL(String queryString, Map<String, Object> map);

    /**
     * 执行事务
     *
     * @param queryParameterList 要执行的QL语句集合
     * @return 操作结果 true | false
     */
    public boolean executeTransactionalByQL(List<QueryParameter> queryParameterList);

    /**
     * 执行事务
     *
     * @param queryParameterList 要执行的SQL语句集合
     * @return 操作结果 true | false
     */
    public boolean executeTransactionalBySQL(List<QueryParameter> queryParameterList);

    /**
     * 根据HQL查询对象
     *
     * @param queryString SQL语句
     * @param maxSize     最大数量
     * @param firstId     第一条记录
     * @param map         参数
     * @return 数据集合
     */
    public List<Object> findObjectByQL(String queryString, int maxSize, int firstId, Map<String, Object> map);
}

