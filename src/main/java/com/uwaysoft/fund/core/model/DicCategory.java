package com.uwaysoft.fund.core.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouchang on 2017/5/19.
 */
@Entity
@Table(name="FU_CO_DIC_CATEGORY")
public class DicCategory {
    private String id;
    private String categoryType;
    private String name;
    private String code;
    private String description;
    private Integer available;
    private Date updateTime;
    private Date createTime;

    private Set<Dic> dics = new HashSet<Dic>();

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "CATEGORY_TYPE",length = 50,nullable = false)
    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Column(length = 50,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 50, nullable = false)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(length = 200,name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "AVAILABLE")
    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToMany(targetEntity = Dic.class,mappedBy = "category",cascade = CascadeType.ALL)
    public Set<Dic> getDics() {
        return dics;
    }

    public void setDics(Set<Dic> dics) {
        this.dics = dics;
    }
}
