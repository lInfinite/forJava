package user.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import page.c.Page;
import base.dao.Execute;
import base.dao.ExecuteSql;

public class ProviderDao {
    ResultSet rs;
    Execute ex=new ExecuteSql();
    Page page=new Page();
    //增
    public void add(Provider provider){
    	String add="INSERT INTO provider VALUES(provider_sequence.nextval,?,?,?,?,?,?,?) ";
    	int num=provider.getNum();
    	String name=provider.getName();
    	String describe=provider.getDescribe();
    	String preson=provider.getPreson();
    	String phone=provider.getPhone();
    	int fax=provider.getFax();
    	String address=provider.getAddress();
    	Object[] parameter={num,name,describe,preson,phone,fax,address};
    	System.out.println("准备插入供货商资料......");
    	ex.change(add, parameter);
    	System.out.println("插入完毕供货商资料......");
    	ex.allClose();
    }
	//删 
    public void delete(int id){
    	String delete="delete from provider where id=?";
    	Object[] parameter={id};
    	System.out.println("准备删除供货商资料......");
    	ex.change(delete, parameter);
    	System.out.println("删除完毕供货商资料......");
    	ex.allClose();
    }
	//改    num=?,name=?,describe=?,preson=?,phone=?,fax=?,address=?where id=?
    public void update(Provider provider){
    	String update1="UPDATE provider SET num=? where id=?";
    	String update2="UPDATE provider SET name=? where id=?";
    	String update3="UPDATE provider SET describe=? where id=?";
    	String update4="UPDATE provider SET preson=? where id=?";
    	String update5="UPDATE provider SET phone=? where id=?";
    	String update6="UPDATE provider SET fax=? where id=?";
    	String update7="UPDATE provider SET address=? where id=?";
    	int num=provider.getNum();
    	String name=provider.getName();
    	String describe=provider.getDescribe();
    	String preson=provider.getPreson();
    	String phone=provider.getPhone();
    	int fax=provider.getFax();
    	String address=provider.getAddress();
    	int id=provider.getId();
    	if(num!=0){
    	Object[] parameter={num,id};
    	ex.change(update1, parameter);
    	ex.allClose();
    	}
    	if(name!=null){
    		Object[] parameter={name,id};
    		ex.change(update2, parameter);
    		ex.allClose();
    	}
    	if(describe!=null){
    		Object[] parameter={describe,id};
    		ex.change(update3, parameter);
    		ex.allClose();
    	}
    	if(preson!=null){
    		Object[] parameter={preson,id};
    		ex.change(update4, parameter);
    		ex.allClose();
    	}
    	if(phone!=null){
    		Object[] parameter={phone,id};
    		ex.change(update5, parameter);
    		ex.allClose();
    	}
    	if(fax!=0){
    		Object[] parameter={fax,id};
    		ex.change(update6, parameter);
    		ex.allClose();
    	}
    	if(address!=null){
    		Object[] parameter={address,id};
    		ex.change(update7, parameter);
    		ex.allClose();
    	}
    }//num,name,describe,preson,phone,fax,address,id
	//查  SELECT id,num,name,describe,preson,phone,fax,address from provider
    public List<Provider> select(int Nobe,int pageSize){
    	String select="SELECT id,num,name,describe,preson,phone,fax,address from (SELECT id,num,name,describe,preson,phone,fax,address,rownum rn from provider) where rn>=? and rn<=?";
    	List<Provider> list=new ArrayList();
    	int top=page.top(Nobe, pageSize);
    	int end=page.end(Nobe, pageSize);
    	Object[] parameter={top,end};
    	rs=ex.select(select, parameter);
    	try {
			while(rs.next()){
		    	Provider provider=new Provider();
				provider.setId(rs.getInt("id"));
				provider.setNum(rs.getInt("num"));
				provider.setName(rs.getString("name"));
				provider.setDescribe(rs.getString("describe"));
				provider.setPreson(rs.getString("preson"));
				provider.setPhone(rs.getString("phone"));
				provider.setFax(rs.getInt("fax"));
				provider.setAddress(rs.getString("address"));
				list.add(provider);
			 }
			
		} catch (SQLException e) {
			System.out.println("遍历出错");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
    	ex.allClose();
    	return list;
    }    
    //条件查询
    public List<Provider> selectLike(int Nobe,int pageSize,String name,String describe){
    	List<Provider> list=new ArrayList();
    	int top=page.top(Nobe, pageSize);
    	int end=page.end(Nobe, pageSize);
       if(name!="%%"&&describe.equals("%%")){  
      	Object[] parameter={top,end,name};
       	String select="SELECT id,num,name,describe,preson,phone,fax,address from provider where id>=? and id<=? and name like? ";
       	rs=ex.select(select, parameter);
       }else if(describe!="%%"&&name.equals("%%")){  
       	Object[] parameter={top,end,describe};
       	String select="SELECT id,num,name,describe,preson,phone,fax,address from provider where id>=? and id<=? and describe like? ";
       	rs=ex.select(select, parameter);
      }else if(name!="%%"&&describe!="%%"){
    	Object[] parameter={top,end,name,describe};
    	String select="SELECT id,num,name,describe,preson,phone,fax,address from provider where id>=? and id<=? and name like ? and describe like? ";
    	rs=ex.select(select, parameter);
    	}
    	try {
    		while(rs.next()){
    			Provider provider=new Provider();
    			provider.setId(rs.getInt("id"));
    			provider.setNum(rs.getInt("num"));
    			provider.setName(rs.getString("name"));
    			provider.setDescribe(rs.getString("describe"));
    			provider.setPreson(rs.getString("preson"));
    			provider.setPhone(rs.getString("phone"));
    			provider.setFax(rs.getInt("fax"));
    			provider.setAddress(rs.getString("address"));
    			list.add(provider);
    		}
    		
    	} catch (SQLException e) {
    		System.out.println("遍历出错");
    		e.printStackTrace();
    		ex.allClose();
    		return null;
    	}
    	ex.allClose();
    	return list;
    }    
    
    public int all(){  
    	String count="SELECT count(*) from provider";
    	ExecuteSql msl=new ExecuteSql();
    	int a=0;
    	Object[] params={};
    	ResultSet rs=msl.select(count, params);
    	try {
			while(rs.next()){
				a=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return a;
    }
}
