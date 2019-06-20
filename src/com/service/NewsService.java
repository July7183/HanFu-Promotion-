package com.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NewsDao;
import com.entity.News;

@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class NewsService{
	@Resource	
	private NewsDao newsDao;
	

	//获取列表
		public List<News> getNewsList(int page, int rows) {

			if (page < 1) {
				page = 1;
			}
			return newsDao.getNewsList(page, rows);
		}
		
		
		//获取总数
		public int getNewsTotal(){
			return newsDao.getAllNews().size();
		}
		
		
		
		//添加新闻
		public boolean addNews(News news) {
			news.setTime(new Date());
			news.setUpdatetime(new Date());
			return newsDao.save(news) > 0;
		}
		
		//修改新闻
		public boolean updateNews(News news) {
			news.setUpdatetime(new Date());
			return newsDao.update(news);
		}

		//删除新闻
		public boolean deleteNews(News news) {
			return newsDao.delete(news);
		}
		
		//获取前五条最新新闻, 放于首页
		public List<News> getNewsIndex() {
			return newsDao.getNewsList(1, 5);
		}

		//通过id获取单个新闻
		public News get(int id) {
			return newsDao.get(News.class,id);
		}
}