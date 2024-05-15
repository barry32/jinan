package com.shanghai.jinan.controller;

import com.shanghai.jinan.service.IDestinationBizService;
import com.shanghai.jinan.vo.ApiResponse;
import com.shanghai.jinan.vo.CityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/city")
public class CityController {
    @Autowired
    private IDestinationBizService iDestinationBizService;

    @PostMapping("/items")
    public ApiResponse<List<CityVo>> getCityList() {
        List<CityVo> cityList = iDestinationBizService.getCityList();
        return new ApiResponse<>(ApiResponse.RS_CODE_SUCCESS, "success",cityList);
    }

    @PostMapping("/delayed/items")
    public ApiResponse<List<CityVo>> getCityListDelayed() throws InterruptedException {
        Thread.sleep(2000);
        List<CityVo> cityList = iDestinationBizService.getCityList();
        return new ApiResponse<>(ApiResponse.RS_CODE_SUCCESS, "success",cityList);
    }
}
