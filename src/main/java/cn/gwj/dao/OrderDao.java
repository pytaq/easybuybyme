package cn.gwj.dao;

import cn.gwj.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 订单处理的dao层
 * getRowCount
 * getRowList(Params params)
 * getById(Integer id)
 * addObject(Params params)
 */
public interface OrderDao {

	public void add(Order order) ;

	public void deleteById(Integer id);
	
	public Order getOrderById(Integer id) ;
	
	public List<Order> getOrderList(@Param("userId") Integer userId, @Param("currentPageNo") Integer currentPageNo,@Param("pageSize") Integer pageSize) ;
	
	public Integer count(Integer userId);
}
