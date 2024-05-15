package com.shanghai.jinan.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityVo implements Serializable {

    private String cityid;

    private String city;

    private String provinceid;
}
