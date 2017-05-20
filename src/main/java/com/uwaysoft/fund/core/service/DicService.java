package com.uwaysoft.fund.core.service;

import com.uwaysoft.fund.core.model.Dic;
import com.uwaysoft.fund.core.model.DicCategory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhouchang on 2017/5/18.
 */
public interface DicService {

    /**
     * 以为字典分类编码获取所有的字典对象
     * @param categoryCode
     * @return List<Dic>
     */
    List<Dic> findByCategoryCode(String categoryCode);

    /**
     * 获取字典分类对象by id
     * @param id
     * @return
     */
    DicCategory findDicCategoryById(String id);

    /**
     * 以字典分类编码和字典编码获取唯一字典对象
     * @param categoryCode
     * @param dicCode
     * @return Dic
     */
    Dic findOneDic(String categoryCode, String dicCode);

    /**
     *  通过ID获取唯一对象
     * @param id
     * @return Dic
     */
    Dic findById(String id);

    /**
     * 保存字典分类对象
     * @param category
     */
    void saveDicCategory(DicCategory category);

    /**
     * 保存字典对象
     * @param dic
     */
    void saveDic(Dic dic);

}
