package com.shanghai.jinan.mapper;

import com.shanghai.jinan.entity.Cities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CitiesDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Cities record);

    int insertSelective(Cities record);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);


    List<Cities> findLimited();
}