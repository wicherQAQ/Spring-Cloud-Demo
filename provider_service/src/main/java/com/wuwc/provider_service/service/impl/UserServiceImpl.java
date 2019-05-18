package com.wuwc.provider_service.service.impl;

import com.wuwc.common.domain.User;
import com.wuwc.provider_service.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getOne() {
        return new User("xiaoming",1);
    }

    @Override
    public List<User> getList() {
        List<User> list =new ArrayList<>();
        list.add(new User("xiaoming",1));
        list.add(new User("wicher",18));
        list.add(new User("张三",2));
        return list;
    }
}
