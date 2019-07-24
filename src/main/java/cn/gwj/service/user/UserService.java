package cn.gwj.service.user;

import cn.gwj.entity.SearchPm;
import cn.gwj.entity.User;

import java.util.List;

public interface UserService {

	public boolean add(User user);
	
	public boolean update(User user);
	
	public boolean deleteUserById(Integer userId);
	
	public User getUser(Integer userId,String loginName);
	
	public List<User> getUserList(SearchPm searchPm);
	
	public int count();
}
