package com.kaishengit.action;

import com.kaishengit.pojo.User;
import com.kaishengit.service.UserService;
import com.kaishengit.util.QueryParam;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Mxia on 2017/3/21.
 */
@Namespace("/user")
public class UserAction extends BaseAction {

    @Autowired
    private UserService userService;

    private List<User>  userList;
    private User user;
    private String userName;
    private Integer id;



    @Action("list")
    public String list() {
        List<QueryParam> queryParamList =QueryParam.builderQueryNameByRequest(getHttpServletRequest());

        userList = userService.findUserByQueryName(queryParamList);
        //userList = userService.findAll();
        return SUCCESS;
    }


    @Action("new")
    public String execute() {
        return SUCCESS;
    }

    @Action(value = "add",results = {
            @Result(type = "redirectAction",params = {"actionName","list"})
    })
    public String save() {
        System.out.println(userName);
        System.out.println(user);
        userService.save(user);
        return SUCCESS;
    }

    @Action(value = "del",results = {
            @Result(type = "redirectAction",params = {"actionName","list"})
    })
    public String del() {
        userService.del(id);
        return  SUCCESS;
    }
    @Action(value = "edit")
    public String edit() {
        user = userService.findById(id);
        return SUCCESS;
    }

    @Action(value = "reEdit",results = {
            @Result(type = "redirectAction",params = {"actionName","list"})
    })
    public String reEdit() {
        userService.update(user);
        return  SUCCESS;
    }



    //get set
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
