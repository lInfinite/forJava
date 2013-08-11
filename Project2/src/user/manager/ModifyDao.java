package user.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

import page.c.Page;

import base.dao.*;

//select id,num AS ���,sum AS ���,quantity AS ����,type AS ��λ ,name AS ����,describe AS ����,payment AS ����,
//provider AS ����,time AS ʱ�� from project_two_modify;
public class ModifyDao{
    ResultSet rs;
    Execute ex=new ExecuteSql();
    Page page=new Page();
    //��
    public void add(Modify modify){
    	String add="INSERT INTO project_two_modify VALUES(modify_sequence.nextval,?,?,?,?,?,?,?,sysdate)";
    	int sum=modify.getSum();
    	int quantity=modify.getQuantity();
    	String type=modify.getType();
    	String name=modify.getName();
    	String describe=modify.getDescribe();
    	String payment=modify.getPayment();
    	String provider=modify.getProvider();
    	Object[] parameter={sum,quantity,type,name,describe,payment,provider};
    	System.out.println("׼�������˵�������������");
    	ex.change(add, parameter);
    	System.out.println("��������˵�������������");
    	ex.allClose();
    	
    }
    //ɾ
    public void delete(int id){
    	String delete="delete from project_two_modify where id=?";
    	Object[] parameter={id};
    	System.out.println("׼��ɾ���˵�......");
    	ex.change(delete, parameter);
    	System.out.println("ɾ������˵�.....");
    	ex.allClose();
    }
    //��
    //SET sum=?,quantity=?,type=?,name=?,describe=?,payment=?,provider=? where id=?
    public void update(Modify modify){
    	String update1="UPDATE project_two_modify SET sum=? where id=?";
    	String update2="UPDATE project_two_modify SET quantity=? where id=?";
    	String update3="UPDATE project_two_modify SET type=? where id=?";
    	String update4="UPDATE project_two_modify SET name=? where id=?";
    	String update5="UPDATE project_two_modify SET describe=? where id=?";
    	String update6="UPDATE project_two_modify SET payment=? where id=?";
    	String update7="UPDATE project_two_modify SET provider=? where id=?";
    	int sum=modify.getSum();
    	int quantity=modify.getQuantity();
    	String type=modify.getType();
    	String name=modify.getName();
    	String describe=modify.getDescribe();
    	String payment=modify.getPayment();
    	String provider=modify.getProvider();
    	int id=modify.getId();
    	if(sum!=0){
    	Object[] parameter={sum,id};
    	ex.change(update1, parameter);
    	ex.allClose();
    	}
    	if(quantity!=0){
    		Object[] parameter={quantity,id};
    		ex.change(update2, parameter);
    		ex.allClose();
    	}
    	if(type!=null){
    		Object[] parameter={type,id};
    		ex.change(update3, parameter);
    		ex.allClose();
    	}
    	if(name!=null){
    		Object[] parameter={name,id};
    		ex.change(update4, parameter);
    		ex.allClose();
    	}
    	if(describe!=null){
    		Object[] parameter={describe,id};
    		ex.change(update5, parameter);
    		ex.allClose();
    	}
    	if(payment!=null){
    		Object[] parameter={payment,id};
    		ex.change(update6, parameter);
    		ex.allClose();
    	}
    	if(provider!=null){
    		Object[] parameter={provider,id};
    		ex.change(update7, parameter);
    		ex.allClose();
    	}
    }//sum,quantity,type,name,describe,payment,provider,id
    
    //��
    public List<Modify> select(int Nobe,int pageSize){
    	String select="select id,sum,quantity,type,name,describe,payment,provider,time from (select id,sum,quantity,type,name,describe,payment,provider,time,ROWNUM rn from project_two_modify) where rn>=? and rn<=?";
    	List<Modify> mlist=new ArrayList<Modify>();
    	int top=page.top(Nobe, pageSize);
    	int end=page.end(Nobe, pageSize);
    	Object[] parameter={top,end};
    	rs=ex.select(select, parameter);
    	try {
			while(rs.next()){
				int id=rs.getInt("id");
				int sum=rs.getInt("sum");
				int quantity=rs.getInt("quantity");
				String type=rs.getString("type");
				String name=rs.getString("name");
				String describe=rs.getString("describe");
				String payment=rs.getString("payment");
				String provider=rs.getString("provider");
				Timestamp time=rs.getTimestamp("time");
				Modify modify=new Modify();
				modify.setId(id);
				modify.setSum(sum);
				modify.setQuantity(quantity);
				modify.setType(type);
				modify.setName(name);
				modify.setDescribe(describe);
				modify.setPayment(payment);
				modify.setProvider(provider);
				modify.setTime(time);
				mlist.add(modify);
			}
		} catch (SQLException e) {
			System.out.println("�����������");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
    	ex.allClose();
    	return mlist;
    }
    //��������
    public List<Modify> selectLike(int Nobe,int pageSize,String Name,String Payment){
    	List<Modify> mlist=new ArrayList<Modify>();
    	int top=page.top(Nobe, pageSize);
    	int end=page.end(Nobe, pageSize);
    	String select=null;
    	System.out.println("��ѯ����"+Nobe+"   ��ѯ�����"+pageSize+"   ����"+Name+"   �Ƿ񸶿�"+Payment);
    	if(Name!=""&&Payment.equals("")){
        	select="select id,sum,quantity,type ,name,describe,payment,provider,time from project_two_modify where id>=? and id<=? and name like ?";
        	Object[] parameter={top,end,Name};
        	rs=ex.select(select, parameter);
    		System.out.println("����Ʒ����ѯ");
    	}else if(Name.equals("%%")&&Payment!=""){
        	select="select id,sum,quantity,type ,name,describe,payment,provider,time from project_two_modify where id>=? and id<=? and payment=?";
        	Object[] parameter={top,end,Payment};
        	rs=ex.select(select, parameter);
    		System.out.println("�����ѯ");
    	}else if(Name!=""&&Payment!=""){
    	    select="selectid,sum,quantity,type ,name,describe,payment,provider,time from project_two_modify where id>=? and id<=? and name like ? and payment=?";
    	    Object[] parameter={top,end,Name,Payment};
        	rs=ex.select(select, parameter);
    		System.out.println("ȫ��������ѯ");
    	}
    	try {
			while(rs.next()){
				int id=rs.getInt("id");
				int sum=rs.getInt("sum");
				int quantity=rs.getInt("quantity");
				String type=rs.getString("type");
				String name=rs.getString("name");
				String describe=rs.getString("describe");
				String payment=rs.getString("payment");
				String provider=rs.getString("provider");
				Timestamp time=rs.getTimestamp("time");
				Modify modify=new Modify();
				modify.setId(id);
				modify.setSum(sum);
				modify.setQuantity(quantity);
				modify.setType(type);
				modify.setName(name);
				modify.setDescribe(describe);
				modify.setPayment(payment);
				modify.setProvider(provider);
				modify.setTime(time);
				mlist.add(modify);
			}
		} catch (SQLException e) {
			System.out.println("�����������");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
    	ex.allClose();
    	return mlist;
    }
	//�ܼ�¼��
    public int all(){
    	int a=0;
    	String count="SELECT count(*) from project_two_modify";
    	Object[] params={};
    	ResultSet rs=ex.select(count, params);
    	try {
			while(rs.next()){
				a=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return a;
    }
    //��Ʒ����
    public List<Provider> selectSP(){
    	String select="select name from provider";
    	List<Provider> list=new ArrayList<Provider>();
    	Object[] parameter={};
    	rs=ex.select(select, parameter);
    	try {
			while(rs.next()){
				String name=rs.getString("name");
				  Provider p=new Provider();
				  p.setName(name);
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("�����������");
			e.printStackTrace();
			ex.allClose();
			return null;
		}
    	ex.allClose();
    	return list;
    }
}
