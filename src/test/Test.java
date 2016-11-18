package test;

import dao.UserDao;
import entity.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lz on 2016/11/18.
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao)context.getBean("userDao");
        User load = userDao.load(1);
        System.out.println(load);
    }
}
