package com.caches.niupule.uidesgin_demo;

/**
 * Created: niupule
 * Date: 2018/5/28  下午2:08
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class DataBean {

    private String data_name;
    private int data_img;

    @Override
    public String toString() {
        return "DataBean{" +
                "data_name='" + data_name + '\'' +
                ", data_img=" + data_img +
                '}';
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public int getData_img() {
        return data_img;
    }

    public void setData_img(int data_img) {
        this.data_img = data_img;
    }

    public DataBean() {

    }

    public DataBean(String data_name, int data_img) {

        this.data_name = data_name;
        this.data_img = data_img;
    }
}
