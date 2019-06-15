package com.huiwei.bean;

/**
 * @ClassName OrderItem
 * @Description 订单项
 * @Author HuiWei
 * @Date 2019/6/15 16:28
 **/
public class OrderItem {
    //商品数量
    private int quantity;
    //订单项对应的商品
    private Product product;
    //订单项对应的订单
    private Order order;
    //订单项对应的账户
    private User user;
    //订单项id
    private int id;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
