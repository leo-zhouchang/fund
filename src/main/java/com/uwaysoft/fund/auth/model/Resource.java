package com.uwaysoft.fund.auth.model;

import com.uwaysoft.fund.core.model.Dic;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhouchang on 2017/5/18.
 */
public class Resource {

    private String id;
    private String name;
    private String type;
    private String url;
    private Resource parentResource;
    private String permission;
    private Dic available;
    private Date createTime;
    private User createUser;

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(length = 200)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "PARENT_ID",length = 32)
    @ManyToOne(targetEntity = Resource.class,fetch = FetchType.LAZY)
    public Resource getParentResource() {
        return parentResource;
    }

    public void setParentResource(Resource parentResource) {
        this.parentResource = parentResource;
    }

    @Column(length = 100)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @ManyToOne(targetEntity = Dic.class,fetch = FetchType.LAZY)
    public Dic getAvailable() {
        return available;
    }

    public void setAvailable(Dic available) {
        this.available = available;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
}
