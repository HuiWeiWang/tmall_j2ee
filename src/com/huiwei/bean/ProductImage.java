package com.huiwei.bean;

/**
 * @ClassName ProductImage
 * @Description 商品图片类
 * @Author HuiWei
 * @Date 2019/6/15 16:08
 **/
public class ProductImage {
    private String type;
    private Product product;
    private int id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
