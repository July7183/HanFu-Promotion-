 package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.News;



@Repository // 注册dao层bean等同于@Component
 public class NewsDao extends BaseDao{
	 
	//分页查询部分新闻//先排序再分页
	public List<News> getNewsList(int page, int rows) {
		return getSession().createQuery("from News order by id desc", News.class)
				.setFirstResult(rows*(page-1)).setMaxResults(rows).list();
	}
	
	
	//获取所有新闻(按时间排序)
	public List<News> getAllNews() {
		return getSession().createQuery("from News order by time desc", News.class).list();
	}
	
 }