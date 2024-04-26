package com.cpt202.demo.Dao;

import com.cpt202.demo.entity.TypeInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TypeInfoDao extends Mapper<TypeInfo> {

    List<TypeInfo> findByName(@Param("name") String name);
}