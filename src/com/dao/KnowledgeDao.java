 package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Knowledge;



@Repository // 注册dao层bean等同于@Component
 public class KnowledgeDao extends BaseDao{
	 
	//分页查询部分新闻//先排序再分页
	public List<Knowledge> getKnowledgeList(int page, int rows) {
		return getSession().createQuery("from Knowledge order by id desc", Knowledge.class)
				.setFirstResult(rows*(page-1)).setMaxResults(rows).list();
	}
	
	
	//获取所有新闻(按时间排序)
	public List<Knowledge> getAllKnowledge() {
		return getSession().createQuery("from Knowledge order by time desc", Knowledge.class).list();
	}
	
 }