package com.uwaysoft.fund.auth.model;

import com.uwaysoft.fund.core.model.Dic;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by zhouchang on 2017/5/18.
 */
@Table(name="FU_AU_USER_LOGIN")
public class UserLogin {
    private String id;
    private String loginId;
    private String salt;
    private String password;
    private Dic accountStatus;
    private User user;
    private Dic available;
    private Date passwordUpdateTime;
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

    @Column(name="LOGIN_ID",length = 200,nullable = false)
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name="SALT",length = 32,nullable = false)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name="PASSWORD",length = 32,nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ACC_STATUS",length = 32)
    @ManyToOne(targetEntity = Dic.class,fetch = FetchType.LAZY)
    public Dic getAccountStatus() {
        return accountStatus;
    }


    public void setAccountStatus(Dic accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Column(name = "USER_ID",length = 32)
    @OneToOne(targetEntity = User.class,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(targetEntity = Dic.class,fetch = FetchType.LAZY)
    public Dic getAvailable() {
        return available;
    }

    public void setAvailable(Dic available) {
        this.available = available;
    }

    @Column(name="PASSWORD_UPDATE_TIME", updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(Date passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }

    @Column(name="CREATE_TIME", updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "CREATE_USER",length = 32)
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }
}
