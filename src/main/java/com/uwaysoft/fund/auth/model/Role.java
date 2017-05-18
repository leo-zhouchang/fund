package com.uwaysoft.fund.auth.model;

import com.uwaysoft.fund.core.model.Dic;
import org.hibernate.annotations.GenericGenerator;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouchang on 2017/5/18.
 */
@Table(name = "FU_AU_ROLE")
public class Role {
    private String id;
    private String name;
    private String code;
    private String description;
    private Dic available;
    private Date createTime;
    private User createUser;

    private Set<User> users = new HashSet<User>();

    private Set<Resource> resources = new HashSet<Resource>();

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(length = 400)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="roles", targetEntity=User.class)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class)
    @JoinTable(name="FU_AU_ROLE_RES",
            joinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="RES_ID", referencedColumnName="ID"))
    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
