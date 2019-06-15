package com.huiwei.bean;

import java.util.List;

/**
 * @ClassName Category
 * @Description 商品分类类
 * @Author HuiWei
 * @Date 2019/6/15 15:33
 **/
public class Category {
    private  String name;
    private int id;
    List<Product> products;
    List<List<Product>> productsByRow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
    /**
      *@Author HuiWei
      *@Description //用于打印信息便于观察，无实际作用
      *@Date 15:39 2019/6/15
      *@Param []
      *@return java.lang.String
    **/
    @Override
    public String toString() {
        return "Category [name="+name+"]";
    }
}
