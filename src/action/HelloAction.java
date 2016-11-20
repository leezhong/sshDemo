package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lizhong on 2016/11/20.
 */
public class HelloAction extends ActionSupport{

    public String say(){
        System.out.println("调用了say方法");
        return null;
    }
}
