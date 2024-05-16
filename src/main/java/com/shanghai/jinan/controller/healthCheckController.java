package com.shanghai.jinan.controller;

import com.shanghai.jinan.vo.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheckController {

    @GetMapping("/health/check")
    public ApiResponse<String> healthCheck() {
        return new ApiResponse<>(ApiResponse.RS_CODE_SUCCESS, "成功", null);
    }
}
