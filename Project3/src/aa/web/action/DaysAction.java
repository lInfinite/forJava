package aa.web.action;

import java.util.List;

import aa.entity.Days;
import aa.entity.Users;
import aa.service.dao.impl.DaysSericeImpl;
import aa.uitl.StaticHibernate;

import com.opensymphony.xwork2.ActionSupport;

public class DaysAction extends ActionSupport{
    
	private DaysSericeImpl dsi;
    private Days days;
	
    //页面交互
    private int page=0;
    private int goPage;
    private int backPage;
    private List<Users> user_list;
    private List<Days> days_list;
    private int read_id;
    private int day_id;
    private String day_submit;
    
    
    
    public String gotoday(){
    	days_list = dsi.selectIdDays(read_id, page);
    	return "day";
    }

    
    public String saveleave(){
    	if(days.getName().equals("") || days.getName()==null){
    		this.addFieldError("NameErorr", "姓名不能为空");
    	}
    	
    	if(days.getTopTime().equals("") || days.getTopTime()==null){
    		this.addFieldError("TopTimeErorr", "开始时间不能为空");
    	}
    	
    	if(days.getEndTime().equals("") || days.getEndTime()==null){
    		this.addFieldError("EndTimeErorr", "开始时间不能为空");
    	}
    	
    	if(days.getDays()<=0){
    		this.addFieldError("DaysErorr", "请填上天数");
    	}
    	if(this.hasFieldErrors()){
    		return "leave";
    	}
		days.setStatus("未审批");
		dsi.saveDays(days);
		return "day";
	}
	
	public String changeStatus(){
		days.setStatus(day_submit);
		dsi.updateDays(days);
		return "day";
	}
	
	
	public String gotoleave(){
		user_list = dsi.selectUsers();
		return "leave";
	}
	
	
	public String check(){
		days = dsi.createDays(day_id);
	    return "check";
	}
	
	
	
	/**
	 * getter and setter
	 * */
	
	public int getDay_id() {
		return day_id;
	}

	public void setDay_id(int day_id) {
		this.day_id = day_id;
	}


	public DaysSericeImpl getDsi() {
		return dsi;
	}

	public void setDsi(DaysSericeImpl dsi) {
		this.dsi = dsi;
	}


	public Days getDays() {
		return days;
	}

	public void setDays(Days days) {
		this.days = days;
	}

	
	public List<Users> getUser_list() {
		return user_list;
	}

	public void setUser_list(List<Users> user_list) {
		this.user_list = user_list;
	}

	
	public List<Days> getDays_list() {
		return days_list;
	}

	public void setDays_list(List<Days> days_list) {
		this.days_list = days_list;
	}

	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
	public int getGoPage() {
		/*return goPage;*/
		return page+StaticHibernate.maxPage;
	}
	
	public void setGoPage(int goPage) {
		this.goPage = goPage;
	}
	
	
	public int getBackPage() {
		/*return backPage;*/
		return page-StaticHibernate.maxPage;
	}
	
	public void setBackPe(int backPage) {
		this.backPage = backPage;
	}

	public int getRead_id() {
		return read_id;
	}

	public void setRead_id(int read_id) {
		this.read_id = read_id;
	}

	public String getDay_submit() {
		return day_submit;
	}

	public void setDay_submit(String day_submit) {
		this.day_submit = day_submit;
	}


	
}
