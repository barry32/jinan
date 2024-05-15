package com.shanghai.jinan.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * areas
 * @author 
 */
@Data
public class Areas implements Serializable {
    private Integer id;

    private String areaid;

    private String area;

    private String cityid;

    private static final long serialVersionUID = 1L;
}