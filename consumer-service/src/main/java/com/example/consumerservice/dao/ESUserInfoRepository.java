package com.example.consumerservice.dao;

import com.example.consumerservice.model.UserInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESUserInfoRepository extends ElasticsearchRepository<UserInfo, String> {
}
