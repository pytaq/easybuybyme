package cn.gwj.service.news;

import cn.gwj.dao.NewsDao;
import cn.gwj.entity.News;
import cn.gwj.param.NewsParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;

	public void deleteNews(String id) {// 删除新闻
		try {
			newsDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public News findNewsById(String id) {// 根据ID获取新闻
		News news = null;
		try {
			newsDao.getNewsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

	public void addNews(News news) {// 保存新闻
		try {
			newsDao.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateNews(News news) {// 更新留言
		try {
			newsDao.update(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<News> queryNewsPageList(NewsParams param){
		List<News> newsList=new ArrayList<News>();
		try {
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}
	
	@Override
	public List<News> queryNewsList(NewsParams param) {
		List<News> newsList=new ArrayList<News>();
		try {
			newsList=newsDao.queryNewsList(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public Integer queryNewsCount(NewsParams param) {
		Integer count=0;
		try {
			count=newsDao.queryNewsCount(param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

}
