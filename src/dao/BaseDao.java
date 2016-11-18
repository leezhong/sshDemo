package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;
import utils.Pagination;
import utils.QueryResult;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by lz on 2016/11/18.
 */
public interface BaseDao {
    <T> T load(Serializable var1, Class<T> var2);

    Serializable create(Object var1);

    void saveOrUpdateAll(List var1);

    <T> T update(T var1);

    boolean remove(Object var1);

    List find(String var1, Object[] var2, Type[] var3, int var4, int var5);

    List find(String var1, Object[] var2, int var3, int var4);

    List find(String var1, Object var2, Type var3, int var4, int var5);

    List find(String var1, Object var2, int var3, int var4);

    List find(String var1, int var2, int var3);

    Session getHibernateInnerSession();

    SessionFactory getHibernateSessionFactory();

    void closeSession(Session var1);

    List findListItemsBySql(String var1, Class var2, Object[] var3, int var4, int var5);

    QueryResult findQueryResultBySql(String var1, Class var2, Object[] var3, Pagination var4);

    Long findByAggregateBySQLQuery(String var1, Object[] var2);

    Object findByAggregate(String var1, Object[] var2);

    QueryResult findItemsByHql(String var1, Object[] var2, Pagination var3, Map var4);
}
