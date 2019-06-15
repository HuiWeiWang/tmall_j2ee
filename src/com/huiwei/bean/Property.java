package com.huiwei.bean;

/**
 * @ClassName Property
 * @Description 商品属性类
 * @Author HuiWei
 * @Date 2019/6/15 15:42
 **/
public class Property {
    private String name;
    private String id;
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
