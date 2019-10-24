package com.o2o.common;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.List;

public class ServiceResponse<T> {
    private  int status;
    private  String msg;
    private  T data;
    private List<T> datas;
    private ServiceResponse(int status){
        this.status=status;
    }
    private ServiceResponse(int status,String msg){
        this.status=status;
        this.msg=msg;
    }
    private ServiceResponse(int status,String msg,T data){
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
    private ServiceResponse(int status,T data){
        this.status=status;
        this.data=data;
    }

    public ServiceResponse(int code, String msg, T data, List<T> datas) {
        this.status = code; this.msg=msg; this.data=data; this.datas = datas;
    }

    //响应成功
    @JsonIgnore
    public boolean isSuccess(){
        return this.status==ResponseCode.SUCCESS.getCode();
    }
    public T getData(){
        return  data;
    }
    public  String getMsg(){
        return msg;
    }
    public int getStatus(){
        return status;
    }
    public static <T> ServiceResponse<T> createBysuccess(){
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServiceResponse<T> createBysuccessMessage(String msg){
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServiceResponse<T> createBysuccessMessage(T data){
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServiceResponse<T> createBysuccessMessage(String msg,T data){
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> ServiceResponse<T> createBysuccessMessage(String msg,T data,List<T> datas){
        return new ServiceResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data,datas);
    }
    public static <T> ServiceResponse<T> createByError(){
        return new ServiceResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServiceResponse<T> createByErrorMessage(String msg){
        return new ServiceResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServiceResponse<T> createByErrorCodeMessage(int code,String msg){
        return new ServiceResponse<T>(code,msg);
    }
}
