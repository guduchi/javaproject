package com.bangshuo.kuaigong.utils;
import java.io.UnsupportedEncodingException;  
import sun.misc.*;  


/**
 * @概述： Base64工具类
 * @文件名： Base64.java
 * @作者： 李奎
 * @创建时间： 2017-7-5
 */
public class Base64 {  
	/**
     * Base64的加密方法
     * @param s 待加密数据
     * @return 加密后的数据
     */
    public static String encryptBase64(String str) {  
        byte[] b = null;  
        String s = null;  
        try {  
            b = str.getBytes("utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }
        if (b != null) {  
            s = new BASE64Encoder().encode(b);  
        }  
        return s;  
    }  
    /**
     * Base64的解密方法
     * @param s 待解密数据
     * @return 解密后的数据
     */
    public static String decodeBase64(String s) {  
        byte[] b = null;  
        String result = null;  
        if (s != null) {  
            BASE64Decoder decoder = new BASE64Decoder();  
            try {  
                b = decoder.decodeBuffer(s);  
                result = new String(b, "utf-8");  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  
    /**
     * 测试实例mian方法
     * @param args
     */
    public static void main(String[] args) {
		String data = encryptBase64("那些年的回忆是什么");
		System.out.println(data);
		String re = decodeBase64(data);
		System.out.println(re);
	}
}  