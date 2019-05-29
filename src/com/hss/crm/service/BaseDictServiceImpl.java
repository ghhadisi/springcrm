package com.hss.crm.service;

import com.hss.crm.mapper.BaseDictMapper;
import com.hss.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements BaseDictService {
    @Autowired
    BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}
