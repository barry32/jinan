package com.shanghai.jinan.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.shanghai.jinan.entity.Cities;
import com.shanghai.jinan.mapper.CitiesDao;
import com.shanghai.jinan.service.IDestinationBizService;
import com.shanghai.jinan.utils.RedisUtil;
import com.shanghai.jinan.vo.CityVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DestinationBizServiceImpl implements IDestinationBizService {
    @Autowired
    private CitiesDao citiesDao;
    @Autowired
    private RedisUtil redisUtil;
    private static final String KEY_CITY_ITEMS = "KEY_CITY_ITEMS";
    @Override
    public List<CityVo> getCityList() {
        return getDataCache();
    }

    private List<CityVo> getDataCache() {
        List<CityVo> cityVos = new ArrayList<>();
        Object valueByKey = redisUtil.get(KEY_CITY_ITEMS);
        if (valueByKey != null) {
            cityVos = JSONArray.parseArray((String) valueByKey, CityVo.class);
        } else {
            List<CityVo> data = getData();
            redisUtil.set(KEY_CITY_ITEMS, JSONArray.toJSONString(data));
            cityVos.addAll(data);
        }
        return cityVos;
    }


    private List<CityVo> getData() {
        List<CityVo>  resultList = new ArrayList<>();
        List<Cities> limited = citiesDao.findLimited();
        if (!CollectionUtils.isEmpty(limited)) {
            limited.forEach(item->{
                CityVo cityVo = new CityVo();
                BeanUtils.copyProperties(item, cityVo);
                resultList.add(cityVo);
            });
        }
        return resultList;
    }
}
