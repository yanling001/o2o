package com.o2o.until;


//图片文件的处理工具类
public class ImageUtil {
    public static void main(String[] args) {
        //获取绝对之路径
        //获取当前线程的绝对值路径
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(basePath);
        //
    }

}
