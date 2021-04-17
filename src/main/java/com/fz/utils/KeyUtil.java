package com.fz.utils;

import java.util.Random;

/**
 * @author: FZ
 * @date: 2021/4/17 10:54
 * @description:
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random( );
        int keyId = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(keyId);
    }
}
