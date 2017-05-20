package com.uwaysoft.fund.core.service.impl;

import com.uwaysoft.fund.core.model.Dic;
import com.uwaysoft.fund.core.model.DicCategory;
import com.uwaysoft.fund.core.service.DicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by zhouchang on 2017/5/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class DicServiceImplTest {

    @Autowired
    private DicService dicService;

    @Test
    public void saveDicCategory() throws Exception {
        DicCategory category = new DicCategory();
        category.setName("逻辑删除标识");
        category.setCategoryType("系统");
        category.setCode("NORMAL_OR_DELETED");
        category.setDescription("标识系统中记录是否被逻辑删除");

        Set<Dic> dics = new HashSet<>();

        category.setDics(dics);

        Dic dic = new Dic();
        dic.setCategory(category);
        dic.setName("删除");
        dic.setCode("DELETE");
        dic.setDescription("已被逻辑删除");
        dic.setAvailable(1);
        dic.setCreateTime(new Date());
        dics.add(dic);

        Dic dic1 = new Dic();
        dic1.setCategory(category);
        dic1.setName("正常");
        dic1.setCode("NORMAL");
        dic1.setDescription("正常状态");
        dic1.setAvailable(1);
        dic1.setCreateTime(new Date());
        dics.add(dic1);

        dicService.saveDicCategory(category);

    }

    @Test
    public void saveDic() throws Exception {

    }

    @Test
    public void queryTest(){
        String id = "402881ef5c1f4bb1015c1f4bb88b0000";
    }

}