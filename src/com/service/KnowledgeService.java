package com.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.KnowledgeDao;
import com.entity.Knowledge;

@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class KnowledgeService{
	@Resource	
	private KnowledgeDao knowledgeDao;
	

	//获取列表
		public List<Knowledge> getKnowledgeList(int page, int rows) {

			if (page < 1) {
				page = 1;
			}
			return knowledgeDao.getKnowledgeList(page, rows);
		}
		
		
		//获取总数
		public int getKnowledgeTotal(){
			return knowledgeDao.getAllKnowledge().size();
		}
		
		
		
		//添加新闻
		public boolean addKnowledge(Knowledge knowledge) {
			knowledge.setTime(new Date());
			knowledge.setUpdatetime(new Date());
			return knowledgeDao.save(knowledge) > 0;
		}
		
		//修改新闻
		public boolean updateKnowledge(Knowledge knowledge) {
			knowledge.setUpdatetime(new Date());
			return knowledgeDao.update(knowledge);
		}

		//删除新闻
		public boolean deleteKnowledge(Knowledge knowledge) {
			return knowledgeDao.delete(knowledge);
		}
		
		//获取前五条最新新闻, 放于首页
		public List<Knowledge> getKnowledgeIndex() {
			return knowledgeDao.getKnowledgeList(1, 5);
		}

		//通过id获取单个新闻
		public Knowledge get(int id) {
			return knowledgeDao.get(Knowledge.class,id);
		}
}