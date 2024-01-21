package com.wj.bmyapp.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wj
 * @create_time 2024/1/21
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {


    private int code;

    private String msg;

    private T data;


    public BaseResponse(int code, String msg) {
        this(code, msg, null);
    }
}
