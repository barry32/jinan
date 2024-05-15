package com.shanghai.jinan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * provinces
 * @author 
 */
@Data
public class Provinces implements Serializable {
    private Integer id;

    private String provinceid;

    private String province;

    private static final long serialVersionUID = 1L;
}