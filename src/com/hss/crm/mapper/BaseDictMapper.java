package com.hss.crm.mapper;

import com.hss.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
