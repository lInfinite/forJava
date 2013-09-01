package com.web.action;

import java.util.List;

import com.entity.ClintLevel;
import com.entity.Product;
import com.entity.Region;
import com.entity.ServiceType;
import com.entity.Stock;
import com.service.dao.BasesDao;
import com.service.dao.impl.BasesImpl;
import com.util.Page;

public class BaseAction  extends SuperAction{
    
	/**service**/
	private BasesDao bases_dao = (BasesImpl)context.getBean("BasesImpl");
	/**entity**/
	private ClintLevel clint_level;
	private ServiceType service_type;
	private Region region;
    private Product product;
    private Stock stock;
    /**list**/
	private List<ClintLevel> clint_level_list=null;
	private List<ServiceType> service_type_list=null;
	private List<Region> region_list=null;
	private List<Product> product_list=null;
	private List<Stock> stock_list=null;
	
	
	
	/**初始化action**/
	public BaseAction(){
		page.setMax_results(5);
	}

	
	/**
	 * 客户等级
	 * **/
	
	
	/**初始客户等级**/
	public String clintlevel(){
		String result = super.result(clint_level, "ClintLevel", "base_client_level.jsp");
		clint_level_list = super.list;
		return result;
	}
	
	
    /**初始添加页面**/
    public String create_clintlevel(){
    	return "base_client_level_create.html";
    }
    
    
    /**初始编辑页面**/
	public String update_clintlevel(){
		clint_level = bases_dao.clint_level(clint_level.getId());
		return "base_client_level_update.jsp";
	}
    

    
    /**创建客户等级**/
    public String createClintLevel(){
    	base.add(clint_level);
    	clint_level = null;
    	return clintlevel();
    }
    
    
    /**编辑客户等级**/
    public String updateClintLevel(){
    	base.update(clint_level);
    	clint_level = null;
    	return clintlevel();
    }
    
    
    /**删除客户等级**/
    public String deleteClintLevel(){
    	base.delete(clint_level);
    	clint_level = null;
    	return clintlevel();
    }
    
    
    /**
     * 服务类型
     * **/
    
    
    /**初始化服务类型 **/
    public String service_type(){
		String result = super.result(service_type, "ServiceType", "base_service_type.jsp");
		service_type_list = super.list;
		return result;
    }
    
    
    /**初始化添加服务类型**/
    public String create_service_type(){
    	return "base_service_type_create.html";
    }
    
    
    /**初始化编辑服务类型**/
    public String update_service_type(){
    	service_type = bases_dao.service_type(service_type.getId());
    	return "base_service_type_update.jsp";
    }
    
    
    /**添加服务类型**/
    public String createServiceType(){
    	base.add(service_type);
    	service_type = null;
    	return service_type();
    }
    
    
    /**编辑服务类型**/
    public String updateServiceType(){
    	base.update(service_type);
    	service_type = null;
    	return service_type();
    }
    
    
    /**删除服务类型**/
    public String deleteServiceType(){
    	base.delete(service_type);
    	service_type = null;
    	return service_type();
    }
    
    
    /**
     *地区
     * **/
    
    
    /**初始化地区**/
    public String region(){
		String result = super.result(region, "Region", "base_client_region.jsp");
		region_list = super.list;
		return result;
    }
    
    
    /**初始化添加地区**/
    public String create_region(){
    	return "base_client_region_create.html";
    }
    
    
    /**初始化编辑地区**/
    public String update_region(){
    	region = bases_dao.region(region.getId());
    	return "base_client_region_update.jsp";
    }
    
    
    /**添加地区**/
    public String createRegion(){
    	base.add(region);
    	region = null;
    	return region();
    }
    
    
    /**编辑地区**/
    public String updateRegion(){
    	base.update(region);
    	region = null;
    	return region();
    }
    
    
    /**删除地区**/
    public String deleteRegion(){
    	base.delete(region);
    	region = null;
    	return region();
    }
    
    
    /**
     * 商品
     * **/
    
    
    /**商品**/
    public String product(){
		String result = super.result(product, "Product", "base_product.jsp");
		product_list = super.list;
		return result;
    }
    
    
    /**初始化添加**/
    public String create_product(){
    	return "base_product_create.html";
    }
    
    
    /**初始化更新**/
    public String product_update(){
    	product = bases_dao.product(product.getId());
    	return "base_product_update.jsp";
    }
    
    
    /**添加**/
    public String createProduct(){
    	base.add(product);
    	product = null;
    	return product();
    }
    
    
    /**更新**/
    public String updateProduct(){
    	base.update(product);
    	product = null;
    	return product();
    }
    
    
    /**删除**/
    public String deleteProduct(){
    	base.delete(product);
    	product = null;
    	return product();
    }
    
    
    /**
     * 库存
     * **/

    
    /**库存**/
    public String stock(){
		String result = super.result(stock, "Stock", "base_stock.jsp");
		stock_list = super.list;
		return result;
    }
    
    
    /**初始化添加**/
    public String create_stock(){
    	product_list = base.query("Product");
    	return "base_stock_create.jsp";
    }
    
    
    /**初始化更新**/
    public String update_stock(){
    	stock = bases_dao.stock(stock.getId());
    	product_list = base.query("Product");
    	return "base_stock_update.jsp";
    }
    
    
    /**添加**/
    public String createStock(){
    	base.add(stock);
    	stock=null;
    	return stock();
    }
    
    
    /**更新**/
    public String updateStock(){
    	base.update(stock);
    	stock=null;
    	return stock();
    }
    
    
    /**删除**/
    public String deleteStock(){
    	base.delete(stock);
    	stock=null;
    	return stock();
    }
    
    
    
    /**entity getter and setter**/
	public ClintLevel getClint_level() {
		return clint_level;
	}

	public void setClint_level(ClintLevel clint_level) {
		this.clint_level = clint_level;
	}

	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	public ServiceType getService_type() {
		return service_type;
	}

	public void setService_type(ServiceType service_type) {
		this.service_type = service_type;
	}


	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	/**list getter and setter**/
	public List<ClintLevel> getClint_level_list() {
		return clint_level_list;
	}

	public void setClint_level_list(List<ClintLevel> clint_level_list) {
		this.clint_level_list = clint_level_list;
	}


	public List<ServiceType> getService_type_list() {
		return service_type_list;
	}

	public void setService_type_list(List<ServiceType> service_type_list) {
		this.service_type_list = service_type_list;
	}

	
	public List<Region> getRegion_list() {
		return region_list;
	}

	public void setRegion_list(List<Region> region_list) {
		this.region_list = region_list;
	}


	public List<Product> getProduct_list() {
		return product_list;
	}

	public void setProduct_list(List<Product> product_list) {
		this.product_list = product_list;
	}


	public List<Stock> getStock_list() {
		return stock_list;
	}

	public void setStock_list(List<Stock> stock_list) {
		this.stock_list = stock_list;
	}

    	
}
	
	
