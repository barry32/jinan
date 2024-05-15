/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */
package com.shanghai.jinan.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class ApiResponse<T> {
    /**
     * 默认 成功码
     */
    public final static String RS_CODE_SUCCESS = "00000000";

    /**
     * 默认 错误码
     */
    public final static String RS_CODE_ERROR = "11111111";

    private String rsCode;

    private String msg = "Success";

    private T body;

    public ApiResponse(String rsCode, String msg, T body) {
        this.rsCode = rsCode;
        this.msg = msg;
        this.body = body;
    }
}
