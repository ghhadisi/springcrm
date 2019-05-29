package com.hss.crm.service;

import com.hss.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
