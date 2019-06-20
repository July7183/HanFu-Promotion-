 package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Carousel;



@Repository // 注册dao层bean等同于@Component
 public class CarouselDao extends BaseDao{
	 
	//分页查询
	public List<Carousel> getCarouselList(int page, int rows) {
		return getSession().createQuery("from Carousel order by id desc", Carousel.class)
				.setFirstResult(rows*(page-1)).setMaxResults(rows).list();
	}

 }