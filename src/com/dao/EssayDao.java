 package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Essay;



@Repository // 注册dao层bean等同于@Component
 public class EssayDao extends BaseDao{
	 
	//分页查询部分新闻//先排序再分页
	public List<Essay> getEssayList(int page, int rows) {
		return getSession().createQuery("from Essay order by id desc", Essay.class)
				.setFirstResult(rows*(page-1)).setMaxResults(rows).list();
	}
	
	
	//获取所有新闻(按时间排序)
	public List<Essay> getAllEssay() {
		return getSession().createQuery("from Essay order by time desc", Essay.class).list();
	}
	
 }