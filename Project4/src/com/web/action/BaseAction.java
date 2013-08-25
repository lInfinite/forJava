package com.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dao.BaseDao;
import com.dao.impl.BaseImpl;
import com.entity.ClintLevel;
import com.entity.Product;
import com.entity.Region;
import com.entity.ServiceType;
import com.entity.Stock;
import com.opensymphony.xwork2.ActionSupport;
import com.service.dao.BasesDao;
import com.service.dao.impl.BasesImpl;
import com.util.Page;
import com.util.Util;

public class BaseAction  extends ActionSupport{

	private ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
	private BaseDao base = (BaseImpl)context.getBean("BaseImpl");
	private Util util = (Util)context.getBean("Util");
	private Page page = (Page)context.getBean("Page");
	private BasesDao bases_dao = (BasesImpl)context.getBean("BasesImpl");
	
	private ClintLevel clint_level;
	private ServiceType service_type;
	private Region region;
    private Product product;
    private Stock stock;
    
	private List<ClintLevel> clint_level_list;
	private List<ServiceType> service_type_list;
	private List<Region> region_list;
	private List<Product> product_list;
	private List<Stock> stock_list;
	
	
	
	/**
	 * 客户等级
	 * **/
	//初始客户等级
	public String clintlevel(){
		if(clint_level==null){
		    clint_level_list = base.query("ClintLevel", null, page.getPage(), 5);
		}else{
	    	clint_level_list = base.query("ClintLevel", util.getValue(clint_level), page.getPage(), 5);
		}
		return "base_client_level.jsp";
	}
	
	
    //初始添加页面
    public String create_clintlevel(){
    	return "base_client_level_create.html";
    }
    
    
    //初始编辑页面
	public String update_clintlevel(){
		clint_level = bases_dao.clint_level(clint_level.getId());
		return "base_client_level_update.jsp";
	}
    

    
    //创建客户等级
    public String createClintLevel(){
    	base.add(clint_level);
    	return clintlevel();
    }
    
    
    //编辑客户等级
    public String updateClintLevel(){
    	base.update(clint_level);
    	return clintlevel();
    }
    
    
    //删除客户等级
    public String deleteClintLevel(){
    	base.delete(clint_level);
    	return clintlevel();
    }
    
    
    /**
     * 服务类型
     * **/
    
    //初始化服务类型 
    public String service_type(){
    	if(service_type==null){
    	    service_type_list = base.query("ServiceType", null, page.getPage(), 5);
    	}else{
        	service_type_list = base.query("ServiceType", util.getValue(service_type), page.getPage(), 5);
    	}
    	return "base_service_type.jsp";
    }
    
    
    //初始化添加服务类型
    public String create_service_type(){
    	return "base_service_type_create.html";
    }
    
    
    //初始化编辑服务类型
    public String update_service_type(){
    	service_type = bases_dao.service_type(service_type.getId());
    	return "base_service_type_update.jsp";
    }
    
    
    //添加服务类型
    public String createServiceType(){
    	base.add(service_type);
    	return service_type();
    }
    
    
    //编辑服务类型
    public String updateServiceType(){
    	base.update(service_type);
    	return service_type();
    }
    
    
    //删除服务类型
    public String deleteServiceType(){
    	base.delete(service_type);
    	return service_type();
    }
    
    
    /**
     *地区
     * **/
    
    //初始化地区
    public String region(){
    	if(region==null){
    	    region_list = base.query("Region", null, page.getPage(), 5);
    	}else{
        	region_list = base.query("Region", util.getValue(region), page.getPage(), 5);
    	}
    	return "base_client_region.jsp";
    }
    
    
    //初始化添加地区
    public String create_region(){
    	return "base_client_region_create.html";
    }
    
    
    //初始化编辑地区
    public String update_region(){
    	region = bases_dao.region(region.getId());
    	return "base_client_region_update.jsp";
    }
    
    
    //添加地区
    public String createRegion(){
    	base.add(region);
    	return region();
    }
    
    
    //编辑地区
    public String updateRegion(){
    	base.update(region);
    	return region();
    }
    
    
    //删除地区
    public String deleteRegion(){
    	base.delete(region);
    	return region();
    }
    
    
    /**
     * 商品
     * **/
    
    //商品
    public String product(){
    	if(product==null){
    	    product_list = base.query("Product", null, page.getPage(), 5);
    	}else{
    		product_list = base.query("Product", util.getValue(product), page.getPage(), 5);
    	}
    	return "base_product.jsp";
    }
    
    
    //初始化添加
    public String product_create(){
    	return "base_service_type_create.html";
    }
    
    
    //初始化更新
    public String product_update(){
    	product = bases_dao.product(product.getId());
    	return "base_service_type_update.jsp";
    }
    
    
    //添加
    public String createProduct(){
    	base.add(product);
    	return product();
    }
    
    
    //更新
    public String updateProduct(){
    	base.update(product);
    	return product();
    }
    
    
    //删除
    public String deleteProduct(){
    	base.delete(product);
    	return product();
    }
    
    
    /**
     * 库存
     * **/

    
    //商品
    public String stock(){
    	if(stock==null){
    	    stock_list = base.query("Stock", null, page.getPage(), 5);
    	}else{
    		stock_list = base.query("Stock",util.getValue(stock), page.getPage(), 5);
    	}
    	return "base_stock.jsp";
    }
    
    
    //初始化添加
    public String create_stock(){
    	product_list = base.query("Stock");
    	return "base_stock_create.jsp";
    }
    
    
    //初始化更新
    public String update_stock(){
    	stock = bases_dao.stock(stock.getId());
    	product_list = base.query("Stock");
    	return "base_stock_update.jsp";
    }
    
    
    //添加
    public String createStock(){
    	base.add(stock);
    	return stock();
    }
    
    
    //更新
    public String updateStock(){
    	base.update(stock);
    	return stock();
    }
    
    
    //删除
    public String deleteStock(){
    	base.delete(stock);
    	return stock();
    }
    
    
    
    
	public ClintLevel getClint_level() {
		return clint_level;
	}

	public void setClint_level(ClintLevel clint_level) {
		this.clint_level = clint_level;
	}


	public List<ClintLevel> getClint_level_list() {
		return clint_level_list;
	}


	public void setClint_level_list(List<ClintLevel> clint_level_list) {
		this.clint_level_list = clint_level_list;
	}


	public ServiceType getService_type() {
		return service_type;
	}


	public void setService_type(ServiceType service_type) {
		this.service_type = service_type;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public List<ServiceType> getService_type_list() {
		return service_type_list;
	}


	public void setService_type_list(List<ServiceType> service_type_list) {
		this.service_type_list = service_type_list;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public List<Region> getRegion_list() {
		return region_list;
	}


	public void setRegion_list(List<Region> region_list) {
		this.region_list = region_list;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public List<Product> getProduct_list() {
		return product_list;
	}


	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public List<Stock> getStock_list() {
		return stock_list;
	}


	public void setStock_list(List<Stock> stock_list) {
		this.stock_list = stock_list;
	}

	
    	
}
	
	
