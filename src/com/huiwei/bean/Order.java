package com.huiwei.bean;

import java.util.Date;
import java.util.List;

/**
 * @ClassName Order
 * @Description 订单类
 * @Author HuiWei
 * @Date 2019/6/15 16:17
 **/
public class Order {
    //订单号
    private String orderCode;
    //送货地址
    private String address;
    //送货邮政编码
    private String post;
    //收货人
    private String receiver;
    //收货人手机号
    private String mobile;
    //收货人信息
    private String userMessage;
    //订单创建时间
    private Date createDate;
    //订单付款时间
    private String payDate;
    //发货时间
    private Date deliveryDate;
    //收货时间
    private Date confirmDate;
    //收货人
    private User user;
    //订单id
    private int id;
    //该订单的订单项
    private List<OrderItem> orderItems;
    //订单总价
    private float totalPrice;
    //订单总数量
    private int totalNumber;
    //订单状态
    private String status;

    /**
     * @return java.lang.String
     * @Author HuiWei
     * @Description //订单状态描述，用于订单状态的数据库英文存储和中文界面显示
     * @Date 16:27 2019/6/15
     * @Param []
     **/
    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
//          case OrderDAO.waitPay:
//              desc="待付款";
//              break;
//          case OrderDAO.waitDelivery:
//              desc="待发货";
//              break;
//          case OrderDAO.waitConfirm:
//              desc="待收货";
//              break;
//          case OrderDAO.waitReview:
//              desc="等评价";
//              break;
//          case OrderDAO.finish:
//              desc="完成";
//              break;
//          case OrderDAO.delete:
//              desc="刪除";
//              break;
//          default:
//              desc="未知";
        }
        return desc;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
