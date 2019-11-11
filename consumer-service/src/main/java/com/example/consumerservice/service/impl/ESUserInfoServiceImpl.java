package com.example.consumerservice.service.impl;

import com.example.consumerservice.dao.ESUserInfoRepository;
import com.example.consumerservice.model.UserInfo;
import com.example.consumerservice.service.ESUserInfoService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Service("eSUserInfoService")
public class ESUserInfoServiceImpl implements ESUserInfoService{

    @Autowired
    private ESUserInfoRepository eSUserInfoRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public boolean insert(UserInfo user) {
        boolean falg=false;
        try{
            eSUserInfoRepository.save(user);
            falg=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return falg;
    }

    @Override
    public List<UserInfo> search(String searchContent) {
        //查询单个任意值
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(searchContent)).build();
        //分页查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(searchContent)).withPageable(PageRequest.of(0, 20)).build();
        //查询单个指定值
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("name",searchContent)).build();
        List<UserInfo> poetryList = elasticsearchTemplate.queryForList(searchQuery, UserInfo.class);
        return poetryList;
    }



    @Override
    public List<UserInfo> searchUser(Integer pageNumber, Integer pageSize,String searchContent) {
        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(searchContent);
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable).withQuery(builder).build();
        System.out.println("查询的语句:" + searchQuery.getQuery().toString());
        Page<UserInfo> searchPageResults = eSUserInfoRepository.search(searchQuery);
        return searchPageResults.getContent();
    }
}
