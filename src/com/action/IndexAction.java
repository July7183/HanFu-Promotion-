package com.action;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.entity.Carousel;
import com.entity.Category;
import com.entity.Essay;
import com.entity.Knowledge;
import com.entity.News;
import com.entity.Product;
import com.entity.ProductNew;
import com.entity.ProductSale;
import com.entity.ProductShow;
import com.service.CarouselService;
import com.service.CategoryService;
import com.service.EssayService;
import com.service.KnowledgeService;
import com.service.NewsService;
import com.service.ProductService;
import com.util.PageUtil;

@Namespace("/index")
@Results({
	@Result(name="index",location="/index/index.jsp"),
	@Result(name="header",location="/index/header.jsp"),
	@Result(name="productList",location="/index/product_list.jsp"),
	@Result(name="productShow",location="/index/product_show.jsp"),
	@Result(name="productSale",location="/index/product_sale.jsp"),
	@Result(name="productNew",location="/index/product_new.jsp"),
	@Result(name="detail",location="/index/detail.jsp"),
	@Result(name="news",location="/index/news.jsp"),
	@Result(name="newsmodel",location="/index/newsdetail.jsp"),	
	@Result(name="knowledge",location="/index/knowledge.jsp"),
	@Result(name="knowledgemodel",location="/index/knowledgedetail.jsp"),	
	@Result(name="essay",location="/index/essay.jsp"),
	@Result(name="essaymodel",location="/index/essaydetail.jsp"),	
})	
public class IndexAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private static final int rows = 10;

	private int id;
	private int productid; // 商品id
	private int knowledgeid;//知识点id
	private int essayid;//知识点id
	private int categoryid; // 类目id
	private int flag; // 页面标记
	private String search; // 商品搜索关键词
	
	private Product product; // 商品实体
	private Category category; // 类目实体
	private News news;
	private List<Product> productList; // 商品列表
	private List<ProductShow> showList; // 热销推荐列表
	private List<ProductSale> saleList; // 特价促销列表
	private List<ProductNew> newList; // 最新上架列表
	private List<Category> categoryList; // 分类列表
	private List<News> newses;
	private List<Knowledge> knowledgees;
	private List<Essay> essayes;
	private List<Carousel> carouselList;
	
	
	@Resource
	private ProductService productService;	
	@Resource
	private CategoryService categoryService;
	@Resource
	private NewsService newsService;
	@Resource
	private KnowledgeService knowledgeService;
	@Resource
	private EssayService essayService;
	@Resource
	private CarouselService carouselService;
	
	private Knowledge knowledge;
	private Essay essay;
	
	
	

	/**
	 * 首页
	 * @return
	 */
	@Action("index")
	public String index(){
		carouselList = carouselService.getCarouselList(1, 6);
		newses = newsService.getNewsList(1, 5);
		knowledgees=knowledgeService.getKnowledgeList(1, 5);
		essayes=essayService.getEssayList(1, 5);
		showList = productService.getShowList(1, 4);
		saleList = productService.getSaleList(1, 4);
		newList = productService.getNewList(1, 4);
		flag =1;
		return "index";
	}
	
	/**
	 * 头部信息
	 * @return
	 */
	@Action("header")
	public String header(){
		categoryList = categoryService.getList();
		showList = productService.getShowList(1, 4);
		return "header";
	}
	
	
	
	@Action("news")
	public String news(){
		pageHtml =  PageUtil.getPageTool(request,newsService.getNewsTotal(),page,rows);		// 总页数
		newses = newsService.getNewsList(page,rows);	//	获取新闻列表
		flag = 2;
		return "news";
	}
	/**
	 * 资讯具体内容
	 * @return
	 */
	@Action("newsmodel")
	public String newsmodel(){
		news = newsService.get(id);	
		flag = 2;// 通过id获取单个新闻信息
		return "newsmodel";
	}
	
	
	
	@Action("knowledge")
	public String knowledge(){
		pageHtml =  PageUtil.getPageTool(request,knowledgeService.getKnowledgeTotal(),page,rows);		// 总页数
		knowledgees = knowledgeService.getKnowledgeList(page,rows);	//	获取新闻列表
		flag = 3;
		return "knowledge";
	}
	
	
	/**
	 * 知识点具体内容
	 * @return
	 */
	@Action("knowledgemodel")
	public String knowledgemodel(){
		setKnowledge(knowledgeService.get(id));	
		flag = 3;// 通过id获取单个知识点信息
		return "knowledgemodel";
	}
	
	
	@Action("essay")
	public String essay(){
		pageHtml =  PageUtil.getPageTool(request,essayService.getEssayTotal(),page,rows);		// 总页数
		essayes = essayService.getEssayList(page,rows);	//	获取新闻列表
		flag = 4;
		return "essay";
	}
	
	/**
	 * 文章具体内容
	 * @return
	 */
	@Action("essaymodel")
	public String essaymodel(){
		setEssay(essayService.get(id));	
		flag = 4;// 通过id获取单个知识点信息
		return "essaymodel";
	}
	
	
		
	
	/**
	 * 商品列表
	 * @return
	 */
	@Action("productList")
	public String productList(){
		if (categoryid > 0) {
			category = categoryService.get(categoryid);
		}
		productList = productService.getCategoryList(categoryid, page, 8);
		pageHtml = PageUtil.getPageTool(request, productService.getCategoryTotal(categoryid), page, rows);
		showList = productService.getShowList(1, 4);
		saleList = productService.getSaleList(1, 4);
		newList = productService.getNewList(1, 4);
		
		flag = 5;
		return "productList";
	}
	
	/**
	 * 精品推荐
	 * @return
	 */
	@Action("productShow")
	public String productShow(){
		showList = productService.getShowList(page, rows);
		pageHtml = PageUtil.getPageTool(request, productService.getShowTotal(), page, rows);
		return "productShow";
	}
	
	

	
	/**
	 * 优惠促销
	 * @return
	 */
	@Action("productSale")
	public String productSale(){
		saleList = productService.getSaleList(page, rows);
		pageHtml = PageUtil.getPageTool(request, productService.getSaleTotal(), page, rows);
		return "productSale";
	}
	
	/**
	 * 新品
	 * @return
	 */
	@Action("productNew")
	public String productNew(){
		newList = productService.getNewList(page,rows);
		pageHtml = PageUtil.getPageTool(request, productService.getNewTotal(), page, rows);
		return "productNew";
	}
	

	/**
	 * 详情
	 * @return
	 */
	@Action("detail")
	public String detail(){
		product = productService.get(productid);
		categoryList = categoryService.getList();
		return "detail";
	}
	
	/**
	 * 搜索
	 * @return
	 */
	@Action("search")
	public String search() {
		if (search==null || search.isEmpty()) {
			return productList();
		}
		productList = productService.getSearchList(search, page, rows);
		pageHtml = PageUtil.getPageTool(request, productService.getSearchTotal(search), page, rows);
		
		showList = productService.getShowList(1, 4);
		saleList = productService.getSaleList(1, 4);
		newList = productService.getNewList(1, 4);
		
		return "productList";
	}

	

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<ProductShow> getShowList() {
		return showList;
	}

	public void setShowList(List<ProductShow> showList) {
		this.showList = showList;
	}

	public List<ProductSale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<ProductSale> saleList) {
		this.saleList = saleList;
	}

	public List<ProductNew> getNewList() {
		return newList;
	}

	public void setNewList(List<ProductNew> newList) {
		this.newList = newList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}


	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Knowledge> getKnowledgees() {
		return knowledgees;
	}

	public void setKnowledgees(List<Knowledge> knowledgees) {
		this.knowledgees = knowledgees;
	}

	public int getKnowledgeid() {
		return knowledgeid;
	}

	public void setKnowledgeid(int knowledgeid) {
		this.knowledgeid = knowledgeid;
	}

	public List<Essay> getEssayes() {
		return essayes;
	}

	public void setEssayes(List<Essay> essayes) {
		this.essayes = essayes;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	public Essay getEssay() {
		return essay;
	}

	public void setEssay(Essay essay) {
		this.essay = essay;
	}

	public List<Carousel> getCarouselList() {
		return carouselList;
	}

	public void setCarouselList(List<Carousel> carouselList) {
		this.carouselList = carouselList;
	}

}