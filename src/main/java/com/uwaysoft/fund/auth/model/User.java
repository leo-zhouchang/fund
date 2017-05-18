package com.uwaysoft.fund.auth.model;

import com.uwaysoft.fund.core.model.Dic;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouchang on 2017/5/18.
 */
@Table(name = "FU_AU_USER")
public class User {
    private String id;
    private String name;
    private Dic gender;
    private Dic credentialsType;
    private String credentialsNum;
    private String email;
    private String primaryPhone;
    private String otherTel;
    private String address;
    private String comments;
    private Dic status;
    private Dic available;
    private Date createTime;
    private User createUser;

    private Set<Role> roles = new HashSet<Role>();


    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "GENDER")
    @ManyToOne(targetEntity = Dic.class, fetch = FetchType.LAZY)
    public Dic getGender() {
        return gender;
    }

    public void setGender(Dic gender) {
        this.gender = gender;
    }

    @Column(name="CRED_TYPE",length = 32,nullable = false)
    @ManyToOne(targetEntity = Dic.class,fetch = FetchType.LAZY)
    public Dic getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Dic credentialsType) {
        this.credentialsType = credentialsType;
    }

    @Column(name="CRED_NUM",length = 100,nullable = false)
    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    @Column(length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="PRI_PHONE_NUM",length = 20)
    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    @Column(name="OHTER_TEL",length = 200)
    public String getOtherTel() {
        return otherTel;
    }

    public void setOtherTel(String otherTel) {
        this.otherTel = otherTel;
    }

    @Column(length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(length = 400)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name="STATUS",length = 32,nullable = false)
    @ManyToOne(targetEntity = Dic.class,fetch = FetchType.LAZY)
    public Dic getStatus() {
        return status;
    }

    public void setStatus(Dic status) {
        this.status = status;
    }

    @Column(name="AVAILABLE",length = 32,nullable = false)
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

    @ManyToMany(fetch=FetchType.LAZY, targetEntity=Role.class)
    @JoinTable(name="FU_AU_USER_ROLE",
            joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="ROLE_ID", referencedColumnName="ID"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
