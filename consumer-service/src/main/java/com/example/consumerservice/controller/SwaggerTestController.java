package com.example.consumerservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.consumerservice.model.UserInfo;
import com.example.consumerservice.service.ESUserInfoService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/swaggerTest")
public class SwaggerTestController {

    @Autowired
    private ESUserInfoService esUserInfoService;

    @ResponseBody
    @PostMapping("/search")
    public String queryAccountInfoByAccountName(
            @ApiParam(value = "任意值") @RequestParam(required = true) String searchContent
    ) {
        List<UserInfo> userInfo = esUserInfoService.search(searchContent);
        return JSON.toJSONString(userInfo);
    }

    @ResponseBody
    @PostMapping("/save")
    public String save(
            @ApiParam(value = "姓名") @RequestParam(required = false) String name,
            @ApiParam(value = "年龄") @RequestParam(required = false) Integer age,
            @ApiParam(value = "描述") @RequestParam(required = false) String description
    ) {
        UserInfo userInfo = new UserInfo(name,age,description,new Date());
        esUserInfoService.insert(userInfo);
        return JSON.toJSONString(userInfo);
    }

    @ResponseBody
    @PostMapping("/searchUser")
    public String queryAccountInfo(
            @ApiParam(value = "当前页") @RequestParam(required = false) Integer pageNumber,
            @ApiParam(value = "条数") @RequestParam(required = false) Integer pageSize,
            @ApiParam("searchContent") String searchContent
    ) {
        List<UserInfo> accountInfo = esUserInfoService.searchUser(pageNumber,pageSize,searchContent);
        return JSON.toJSONString(accountInfo);
    }

    @ResponseBody
    @GetMapping("/getStudent")
    public String getStudent(
            @ApiParam(value = "姓名") @RequestParam(required = false) String name,
            @ApiParam(value = "年龄") @RequestParam(required = false) Integer age
    ){
        JSONObject jsonObject = new JSONObject();
        try {
            Map studentMap = new HashMap();
            studentMap.put("name", name);
            studentMap.put("age", age);
            jsonObject.put("code",0);
            jsonObject.put("data",studentMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


}
