package cn.gwj.dao;

import cn.gwj.entity.SearchPm;
import cn.gwj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao  {

	int add(User user) throws Exception;//新增用户信息

	int update(User user) throws Exception;//更新用户信息

	public int deleteUserById(String id) throws Exception;
	
	public List<User> getUserList(SearchPm searchPm)throws Exception;
	
	public Integer count() throws Exception;
	
	public User getUser(@Param("id") Integer id, @Param("loginName") String loginName) throws Exception;
}
