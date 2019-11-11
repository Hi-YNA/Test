package com.example.consumerservice.service;
import com.example.consumerservice.model.UserInfo;

import java.util.List;

public interface ESUserInfoService {

    List<UserInfo> searchUser(Integer pageNumber, Integer pageSize,String searchContent);

    boolean insert(UserInfo user);

    List<UserInfo> search(String searchContent);



}
