package com.fz.VO;

import lombok.Data;

/**
 * @author: FZ
 * @date: 2021/4/15 20:45
 * @description:
 * http请求返回最外层对象
 */
@Data
public class ResultVO<T> {
    //错误码
    private  Integer code;
    //提示信息
    private String msg;
    //具体内容
    private T data;
}
