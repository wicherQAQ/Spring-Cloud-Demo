package com.wuwc.provider_service.service;

import com.wuwc.common.domain.User;

import java.util.List;

public interface UserService {
    User getOne();

    List<User> getList();
}
