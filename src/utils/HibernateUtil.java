package utils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lz on 2016/11/18.
 */
public class HibernateUtil extends HibernateDaoSupport{
        public HibernateUtil() {
        }

        public List find(String var1, int var2, int var3) {
            ArrayList var4 = new ArrayList();
            if(var1 == null) {
                return var4;
            } else {
                Object var5 = null;
                Session var6 = null;
                var6 = this.getSession();
                Query var7 = var6.createQuery(var1);
                var7.setFirstResult(var2);
                var7.setMaxResults(var3);
                return var7.list();
            }
        }

        public List find(String var1, Object var2, Type var3, int var4, int var5) {
            ArrayList var6 = new ArrayList();
            if(var1 == null) {
                return var6;
            } else {
                Object var7 = null;
                Session var8 = null;
                var8 = this.getSession();
                Query var9 = var8.createQuery(var1);
                var9.setParameter(0, var2, var3);
                var9.setFirstResult(var4);
                var9.setMaxResults(var5);
                return var9.list();
            }
        }

        public List find(String var1, Object var2, int var3, int var4) {
            ArrayList var5 = new ArrayList();
            if(var1 == null) {
                return var5;
            } else {
                Object var6 = null;
                Session var7 = null;
                var7 = this.getSession();
                Query var8 = var7.createQuery(var1);
                var8.setParameter(0, var2);
                var8.setFirstResult(var3);
                var8.setMaxResults(var4);
                return var8.list();
            }
        }

        public List find(String var1, Object[] var2, Type[] var3, int var4, int var5) {
            ArrayList var6 = new ArrayList();
            if(var1 == null) {
                return var6;
            } else {
                Object var7 = null;
                Session var8 = null;
                var8 = this.getSession();
                Query var9 = var8.createQuery(var1);

                for(int var10 = 0; var10 < var2.length; ++var10) {
                    var9.setParameter(var10, var2[var10], var3[var10]);
                }

                var9.setFirstResult(var4);
                var9.setMaxResults(var5);
                return var9.list();
            }
        }

        public List find(String var1, Object[] var2, int var3, int var4) {
            ArrayList var5 = new ArrayList();
            if(var1 == null) {
                return var5;
            } else {
                Object var6 = null;
                Session var7 = null;
                var7 = this.getSession();
                Query var8 = var7.createQuery(var1);

                for(int var9 = 0; var9 < var2.length; ++var9) {
                    var8.setParameter(var9, var2[var9]);
                }

                var8.setFirstResult(var3);
                var8.setMaxResults(var4);
                return var8.list();
            }
        }

        public List getNamedQueryResult(String var1, Object[] var2, Type[] var3, int var4, int var5) {
            ArrayList var6 = new ArrayList();
            if(var1 == null) {
                return var6;
            } else {
                Object var7 = null;
                Session var8 = null;
                var8 = this.getSession();
                Query var9 = var8.getNamedQuery(var1);
                var1 = var9.getQueryString();
                var9 = var8.createQuery(var1);

                for(int var10 = 0; var10 < var2.length; ++var10) {
                    var9.setParameter(var10, var2[var10], var3[var10]);
                }

                var9.setFirstResult(var4);
                var9.setMaxResults(var5);
                return var9.list();
            }
        }

}
