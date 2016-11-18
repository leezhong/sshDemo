package dao.impl;

import dao.BaseDao;
import org.hibernate.*;
import org.springframework.orm.hibernate3.HibernateCallback;
import utils.HibernateUtil;
import utils.Pagination;
import utils.QueryResult;

import java.io.Serializable;
import java.util.*;

/**
 * Created by lz on 2016/11/18.
 */
public class BaseDaoImpl extends HibernateUtil implements BaseDao {

    public <T> T load(Serializable var1, Class<T> var2) {
        Object var3 = null;
        var3 = this.getSession().get(var2, var1);
        return (T)var3;
    }

    public Serializable create(Object var1) {
        Serializable var2 = this.getSession().save(var1);
        return var2;
    }

    public void saveOrUpdateAll(List var1) {
        this.getHibernateTemplate().saveOrUpdateAll(var1);
    }

    public <T> T update(T var1) {
        this.getSession().saveOrUpdate(var1);
        return var1;
    }

    public boolean remove(Object var1) {
        this.getSession().delete(var1);
        return true;
    }

    public Session getHibernateInnerSession() {
        return super.getSession();
    }

    public void closeSession(Session var1) {
        this.releaseSession(var1);
    }

    public SessionFactory getHibernateSessionFactory() {
        return super.getSessionFactory();
    }

    public List findListItemsBySql(String var1, Class var2, Object[] var3, int var4, int var5) {
        Session var6 = null;

        try {
            var6 = this.getSession();
            SQLQuery var7 = var6.createSQLQuery(var1);
            var7.addEntity(var2);
            if(var3 != null && var3.length > 0) {
                for(int var8 = 0; var8 < var3.length; ++var8) {
                    var7.setParameter(var8, var3[var8]);
                }
            }

            var7.setFirstResult(var4);
            var7.setMaxResults(var5);
            new ArrayList();
            Object var9 = null;
            List var11 = var7.list();
            return var11;
        } catch (Exception var10) {
            var10.printStackTrace();
            return null;
        }
    }

    @Override
    public QueryResult findQueryResultBySql(String var1, Class var2, Object[] var3, Pagination var4) {
        return null;
    }


    public Long findByAggregateBySQLQuery(String var1, Object[] var2) {
        Session var3 = null;

        try {
            var3 = this.getSession();
            SQLQuery var4 = var3.createSQLQuery(var1);
            var4.addScalar("num", Hibernate.INTEGER);
            if(var2 != null && var2.length > 0) {
                for(int var5 = 0; var5 < var2.length; ++var5) {
                    var4.setParameter(var5, var2[var5]);
                }
            }

            Object var12 = var4.uniqueResult();
            if(var12 == null) {
                new Long(0L);
            }

            Long var6 = Long.valueOf(Long.parseLong(var12.toString()));
            return var6;
        } catch (Exception var10) {
            var10.printStackTrace();
        } finally {
            ;
        }

        return new Long(0L);
    }


    public Object findByAggregate(final String var1, final Object[] var2) {
        return this.getHibernateTemplate().execute(new HibernateCallback() {
            public Object doInHibernate(Session var1x) throws HibernateException {
                try {
                    Query var2x = var1x.createQuery(var1);
                    if(var2 != null && var2.length > 0) {
                        for(int var3 = 0; var3 < var2.length; ++var3) {
                            var2x.setParameter(var3, var2[var3]);
                        }
                    }

                    Iterator var5 = var2x.iterate();
                    return var5.hasNext()?var5.next():new Long(0L);
                } catch (Exception var4) {
                    var4.printStackTrace();
                    return new Long(0L);
                }
            }
        }, true);
    }

    @Override
    public QueryResult findItemsByHql(String var1, Object[] var2, Pagination var3, Map var4) {
        return null;
    }
}