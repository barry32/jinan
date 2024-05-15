package com.shanghai.jinan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * cities
 * @author 
 */
@Data
public class Cities implements Serializable {
    private Integer id;

    private String cityid;

    private String city;

    private String provinceid;

    private static final long serialVersionUID = 1L;
}