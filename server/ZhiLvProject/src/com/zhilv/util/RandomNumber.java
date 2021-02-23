package com.zhilv.util;

/**
 * 
 * @ClassName: RandomNumber   
 * @Description: 生成n位随机数
 * @author: 张璐婷
 * @date: 2021年2月23日 下午5:11:19
 */
public class RandomNumber {

    public long getRandomNumber(int n){
        if(n<1){
            throw new IllegalArgumentException("随机数位数必须大于0");
        }
        return (long)(Math.random()*9*Math.pow(10,n-1)) + (long)Math.pow(10,n-1);
    }
}
