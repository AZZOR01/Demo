package com.cpt202.demo.service;


import com.cpt202.demo.Dao.TypeInfoDao;
import com.cpt202.demo.entity.TypeInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service

public class TypeInfoService {

    @Resource
    private TypeInfoDao typeInfoDao;

    public TypeInfo add(TypeInfo typeInfo) {
        typeInfoDao.insertSelective(typeInfo);
        return typeInfo;
    }

}
