package com.caches.niupule.network_demo.domain;

/**
 * Created: niupule
 * Date: 2018/2/4  下午4:17
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class UserInfo<E> {


    /**
     * user_id : 1
     * user_name : 牛谱乐
     * user_password : 123456
     * user_age : 21
     * user_gender : 男
     * user_intent : java
     * user_school : 广州大学
     * user_address : 广州市天河区大学城外环西路230号
     * user_phone : 13533578766
     * user_money : 8000
     * user_images : null
     */

    private int user_id;
    private String user_name;
    private String user_password;
    private int user_age;
    private String user_gender;
    private String user_intent;
    private String user_school;
    private String user_address;
    private String user_phone;
    private int user_money;
    private Object user_images;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public String getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(String user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_intent() {
        return user_intent;
    }

    public void setUser_intent(String user_intent) {
        this.user_intent = user_intent;
    }

    public String getUser_school() {
        return user_school;
    }

    public void setUser_school(String user_school) {
        this.user_school = user_school;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getUser_money() {
        return user_money;
    }

    public void setUser_money(int user_money) {
        this.user_money = user_money;
    }

    public Object getUser_images() {
        return user_images;
    }

    public void setUser_images(Object user_images) {
        this.user_images = user_images;
    }
}
