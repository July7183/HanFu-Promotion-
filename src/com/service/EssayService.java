package com.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EssayDao;
import com.entity.Essay;

@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class EssayService{
	@Resource	
	private EssayDao essayDao;
	

	//获取列表
		public List<Essay> getEssayList(int page, int rows) {

			if (page < 1) {
				page = 1;
			}
			return essayDao.getEssayList(page, rows);
		}
		
		
		//获取总数
		public int getEssayTotal(){
			return essayDao.getAllEssay().size();
		}
		
		
		
		//添加新闻
		public boolean addEssay(Essay essay) {
			essay.setTime(new Date());
			essay.setUpdatetime(new Date());
			return essayDao.save(essay) > 0;
		}
		
		//修改新闻
		public boolean updateEssay(Essay essay) {
			essay.setUpdatetime(new Date());
			return essayDao.update(essay);
		}

		//删除新闻
		public boolean deleteEssay(Essay essay) {
			return essayDao.delete(essay);
		}
		
		//获取前五条最新新闻, 放于首页
		public List<Essay> getEssayIndex() {
			return essayDao.getEssayList(1, 5);
		}

		//通过id获取单个新闻
		public Essay get(int id) {
			return essayDao.get(Essay.class,id);
		}
}