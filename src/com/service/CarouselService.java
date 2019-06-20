package com.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CarouselDao;
import com.entity.Carousel;

@Service	// 注解为service层spring管理bean
@Transactional	// 注解此类所有方法加入spring事务, 具体设置默认
public class CarouselService{
	@Resource	
	private CarouselDao carouselDao;
	

	//获取列表
		public List<Carousel> getCarouselList(int page, int rows) {

			if (page < 1) {
				page = 1;
			}
			return carouselDao.getCarouselList(page, rows);
		}
		
		//添加轮播图
		public boolean addCarousel(Carousel carousel) {
			return carouselDao.save(carousel) > 0;
		}
		
		//修改轮播图
		public boolean updateCarousel(Carousel carousel) {
			return carouselDao.update(carousel);
		}

		//删除轮播图
		public boolean deleteCarousel(Carousel carousel) {
			return carouselDao.delete(carousel);
		}
		
		//获取6个轮播图, 放于首页
		public List<Carousel> getCarouselIndex() {
			return carouselDao.getCarouselList(1, 6);
		}

		//通过id获取单个轮播图
		public Carousel get(int id) {
			return carouselDao.get(Carousel.class,id);
		}
}