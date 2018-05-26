package com.caches.niupule.materdesgin_demo;

/**
 * Created: niupule
 * Date: 2018/5/25  下午2:31
 * E-mail:niupuyue@aliyun.com
 * des:
 */

public class Fruit {

    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Fruit() {

    }

    public Fruit(String name, int imageId) {

        this.name = name;
        this.imageId = imageId;
    }
}
