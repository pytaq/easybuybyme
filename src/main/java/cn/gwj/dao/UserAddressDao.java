package cn.gwj.dao;

import cn.gwj.entity.UserAddress;
import cn.gwj.param.UserAddressParam;

import java.util.List;

public interface UserAddressDao{
	
	public List<UserAddress> queryUserAddressList(UserAddressParam param);
	
	public Integer add(UserAddress userAddress);
	
	public UserAddress getUserAddressById(Integer addressId);

}
