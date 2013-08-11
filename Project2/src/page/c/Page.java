package page.c;

import java.sql.ResultSet;
import java.sql.SQLException;

import user.manager.ModifyDao;
import base.dao.ExecuteSql;

public class Page {

	//总页数
    public int totalPage(int all,int size){
    	int totalpage=0;
    	if(all%size==0){//如果能整除的情况下
    		totalpage=all/size;//总页数除要显示的行数
    	}else if(all%size>0){//超多+1
    		totalpage=all/size+1;
    	}
    	return totalpage;
    }
    //开始记录数=（当前页-1）*显示行数+1
    public int top(int page,int pageSize){
    	int t;
    	return t=(page-1)*pageSize+1;
    }
    //结束记录数=当前页*显示行数
    public int end(int page,int pageSize){
    	int e;
    	e=page*pageSize;
    	return e;
    }
    //测试
    public static void main(String[] args) {
    	int pageSize=5;
    	ModifyDao md=new ModifyDao();
    	Page p=new Page();
    	int a=md.all();//数据总行数
    	int b=p.totalPage(a, pageSize);//分页的总数
    	int c=p.top(3, pageSize);
    	int d=p.end(3, pageSize);
		System.out.println("总记录数"+a+"   能分成"+b);
		System.out.println("开始"+c+"结束"+d);
	}
}
