package cn.gwj.service.user;

import cn.gwj.dao.UserDao;
import cn.gwj.entity.SearchPm;
import cn.gwj.entity.User;
import cn.gwj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	private Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean add(User user){
		Integer count=0;
		try {
			count=userDao.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return  count>0;
		}
	}

	@Override
	public boolean update(User user) {
		Integer count=0;
		try {
			count=userDao.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return  count>0;
		}
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		Integer count=0;
		try {
			count=userDao.deleteUserById(userId+"");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return  count>0;
		}
	}

	@Override
	public User getUser(Integer userId, String loginName) {
        User user=null;
        try {
            user=userDao.getUser(userId,loginName);
        } catch (Exception e) {
            e.printStackTrace();
        }
//		SqlSession sqlSession= MybatisUtils.createSqlSession();
//		try {
//			user=sqlSession.getMapper(UserDao.class).getUser(userId,loginName);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			MybatisUtils.closeSqlSession(sqlSession);
//
//		}
        return user;
	}

	@Override
	public List<User> getUserList(SearchPm searchPm) {
		List<User> userList=null;
        try {
            userList=userDao.getUserList(searchPm);
        } catch (Exception e) {
            e.printStackTrace();
        }
//		SqlSession sqlSession=MybatisUtils.createSqlSession();
//		try {
//			userList=sqlSession.getMapper(UserDao.class).getUserList(searchPm);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			MybatisUtils.closeSqlSession(sqlSession);
//		}
        return userList;
	}

	@Override
	public int count() {
		Integer count=null;
		try {
			count=userDao.count();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return count;
		}
	}
}
