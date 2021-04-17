package com.fz.utils;

import com.fz.VO.ResultVO;

/**
 * @author: FZ
 * @date: 2021/4/16 14:10
 * @description:
 */
public class ResultVOUtil {
    public  static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO( );
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public  static ResultVO success(){
       return null;
    }
    public  static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO( );
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
