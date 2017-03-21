package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.User;
import com.kaishengit.util.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mxia on 2017/3/21.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
         userDao.save(user);
    }


    public List<User> findAll() {
        return userDao.findAll();
    }

    public void del(Integer id) {
            userDao.delete(id);
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public List<User> findUserByQueryName(List<QueryParam> queryParamList) {
        return userDao.findByQueryParam(queryParamList);
    }
}
