package com.uwaysoft.fund.core.service.impl;

import com.uwaysoft.fund.core.dao.DicDao;
import com.uwaysoft.fund.core.model.Dic;
import com.uwaysoft.fund.core.model.DicCategory;
import com.uwaysoft.fund.core.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhouchang on 2017/5/19.
 */
@Service("dicService")
@Transactional(readOnly = true, rollbackFor = RuntimeException.class)
public class DicServiceImpl implements DicService {

    @Autowired
    private DicDao dicDao;

    @Override
    public List<Dic> findByCategoryCode(String categoryCode) {
        return null;
    }

    @Override
    public DicCategory findDicCategoryById(String id) {
        DicCategory category = new DicCategory();
        category.setId(id);
        //return this.dicDao.find(category);
        return null;
    }

    @Override
    public Dic findOneDic(String categoryCode, String dicCode) {
        return null;
    }

    @Override
    public Dic findById(String id) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveDicCategory(DicCategory category) {
        dicDao.save(category);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveDic(Dic dic) {
        dicDao.save(dic);
    }
}
