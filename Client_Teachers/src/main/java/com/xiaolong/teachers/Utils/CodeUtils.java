package com.xiaolong.teachers.Utils;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {
    @CachePut(value = "mailSpace",key = "#mail")
    public String generator(String mail){
        int i = mail.hashCode();
        int encryption= 20010905;
        //进行异或运算
        long result=i^encryption;
        long nowTime=System.currentTimeMillis();
        result =result^nowTime;
        result=result > 0 ?result:-result;
//        System.out.println(result);
        String last=Long.toString(result);
        String substring = last.substring(last.length() - 6);
//        System.out.println(substring);
//        long code=result %100000;
//        System.out.println(result);
        return substring;
    }
    @Cacheable(value = "mailSpace",key = "#mail")
    public String getCode(String mail){
        return null;
    }
}
