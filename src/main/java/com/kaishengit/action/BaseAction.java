package com.kaishengit.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Action的通用类
 * 用来定义一些 所用action都通用的方法
 *  继承ActionSupport 能够使用一些特殊的属性  等
 * Created by Mxia on 2017/3/20.
 */
public class BaseAction extends ActionSupport {

/**
 *获取session application等对象有两种方式
 * 1.通过ActionContext 对象获取
 * 2.实现相应的 *Aware 接口 来获取  例如 SessionAware
 */


    /**
     * 获请求对象
     * @return
     */
    public HttpServletRequest getHttpServletRequest() {
        return ServletActionContext.getRequest();
    }

    /**
     * 获取原生响应对象
     * @return
     */
    public HttpServletResponse getHttpServletResponse() {
        return ServletActionContext.getResponse();
    }


    /**
     * 获取原生session对象
     * @return
     */
    public HttpSession getHttpSession() {
        return getHttpServletRequest().getSession();
    }

    /**
     * 获取原生application对象
     * @return
     */
    public ServletContext getServletContext() {
        return ServletActionContext.getServletContext();
    }

    /**
     * strusts封装好的
     * @return
     */
    public Map<String,Object> getSession() {
        return ActionContext.getContext().getSession();
    }

    /**
     * strust 封装好的application对象
     * @return
     */
    public Map<String,Object> getApplication() {
        return ActionContext.getContext().getApplication();
    }

}
