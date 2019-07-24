package cn.gwj.service.order;

import cn.gwj.dao.OrderDao;
import cn.gwj.dao.OrderDetailDao;
import cn.gwj.dao.ProductDao;
import cn.gwj.entity.Order;
import cn.gwj.entity.OrderDetail;
import cn.gwj.entity.User;
import cn.gwj.utils.ShoppingCart;
import cn.gwj.utils.ShoppingCartItem;
import cn.gwj.utils.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * 结算购物车物品包含以下步骤：
     * 1.生成订单
     * 2.生成订单明细
     * 3.更新商品表，减库存
     * 注意加入事物的控制
     */
//    @Autowired 两者都可以
    @Resource
    private ProductDao productDao;
    @Resource
    private OrderDao orderDao;
    @Resource
    private OrderDetailDao orderDetailDao;
    @Override
    public Order payShoppingCart(ShoppingCart cart, User user, String address) {
        Order order = new Order();
        try {
            //增加订单
            order.setUserId(user.getId());
            order.setLoginName(user.getLoginName());
            order.setUserAddress(address);
            order.setCreateTime(new Date());
            order.setCost(cart.getTotalCost());
            order.setSerialNumber(StringUtils.randomUUID());
            orderDao.add(order);
            //增加订单对应的明细信息
            for (ShoppingCartItem item : cart.getItems()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderId(order.getId());
                orderDetail.setCost(item.getCost());
                orderDetail.setProduct(item.getProduct());
                orderDetail.setQuantity(item.getQuantity());
                orderDetailDao.add(orderDetail);
                //更新商品表的库存
                productDao.updateStock(item.getProduct().getId(), item.getQuantity());
            }
        } catch (Exception e) {
            order = null;
        }
        return order;
    }

    @Override
    public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {

        List<Order> orderList = new ArrayList<Order>();
        try {
            orderList = orderDao.getOrderList(userId, currentPageNo, pageSize);
            for(Order order:orderList){
            	order.setOrderDetailList(orderDetailDao.getOrderDetailList(order.getId()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return orderList;
        }
    }

    @Override
    public int count(Integer userId) {
        Integer count=0;
        try {
            count=orderDao.count(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return count;
        }
    }

    /**
     * 调用dao接口：OrderDetailMapper的方法实现
     */
    @Override
    public List<OrderDetail> getOrderDetailList(Integer orderId) {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        try {
            orderDetailList = orderDetailDao.getOrderDetailList(orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return orderDetailList;
        }
    }
}
