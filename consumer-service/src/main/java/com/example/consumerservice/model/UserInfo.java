package com.example.consumerservice.model;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;


@Document(indexName = "userinfoindex", type = "userInfo")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;
    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 描述 */
    private String description;

    /** 创建时间 */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserInfo(String name, Integer age, String description, Date createTime) {
        this.name = name;
        this.age = age;
        this.description = description;
        this.createTime = createTime;
    }

    public UserInfo() {
    }
}
