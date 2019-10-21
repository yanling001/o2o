package com.o2o.common.enmu;

//枚举
public enum  Shopenum {
    SUCCESS(1,"操作成功"),CHECK(0,"审核中"),OFFLINE(-1,"非法店铺")
    ,PASS(2,"审核通过"),NULL_SHOP(404,"没有商铺"),DEFAULT(3,"参数错误");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }



    private Shopenum(int i, String msg) {
        this.code=i; this.msg=msg;
    }
}
