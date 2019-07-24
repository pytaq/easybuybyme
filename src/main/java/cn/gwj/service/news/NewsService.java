package cn.gwj.service.news;

import cn.gwj.entity.News;
import cn.gwj.param.NewsParams;

import java.util.List;

public interface NewsService{
	/**
	 * 保存新闻
	 * @param news
	 */
	void addNews(News news);//保存新闻
	/**
	 * 根据id查询新闻
	 * @param parameter
	 * @return
	 */
	News findNewsById(String parameter);
	/***
	 * 删除新闻
	 * @param parameter
	 */
	void deleteNews(String parameter);
	/***
	 * 查询新闻列表
	 * @param param
	 * @return
	 */
	List<News> queryNewsList(NewsParams param);
	/***
	 * 查询数目
	 * @param param
	 * @return
	 */
	Integer queryNewsCount(NewsParams param);

}
