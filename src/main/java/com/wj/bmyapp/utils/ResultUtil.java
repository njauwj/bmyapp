package com.wj.bmyapp.utils;

import com.wj.bmyapp.resp.BaseResponse;

/**
 * @author wj
 * @create_time 2024/1/21
 * @description
 */
public class ResultUtil {


    public static <T> BaseResponse<T> success(T data, String msg) {
        return new BaseResponse<>(1, msg, data);
    }
    public static <T> BaseResponse<T> success(String msg) {
        return new BaseResponse<>(1, msg, null);
    }

    public static <T> BaseResponse<T> failed(String msg) {
        return new BaseResponse<>(0, msg);
    }
}
