package cn.gwj.utils;

import cn.gwj.entity.Order;
import cn.gwj.entity.OrderDetail;

import java.io.Serializable;
import java.util.List;


public class OrderVo implements Serializable {
    private Order order;
    private List<OrderDetail> orderDetailList;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
