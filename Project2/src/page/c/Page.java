package page.c;

import java.sql.ResultSet;
import java.sql.SQLException;

import user.manager.ModifyDao;
import base.dao.ExecuteSql;

public class Page {

	//��ҳ��
    public int totalPage(int all,int size){
    	int totalpage=0;
    	if(all%size==0){//����������������
    		totalpage=all/size;//��ҳ����Ҫ��ʾ������
    	}else if(all%size>0){//����+1
    		totalpage=all/size+1;
    	}
    	return totalpage;
    }
    //��ʼ��¼��=����ǰҳ-1��*��ʾ����+1
    public int top(int page,int pageSize){
    	int t;
    	return t=(page-1)*pageSize+1;
    }
    //������¼��=��ǰҳ*��ʾ����
    public int end(int page,int pageSize){
    	int e;
    	e=page*pageSize;
    	return e;
    }
    //����
    public static void main(String[] args) {
    	int pageSize=5;
    	ModifyDao md=new ModifyDao();
    	Page p=new Page();
    	int a=md.all();//����������
    	int b=p.totalPage(a, pageSize);//��ҳ������
    	int c=p.top(3, pageSize);
    	int d=p.end(3, pageSize);
		System.out.println("�ܼ�¼��"+a+"   �ֳܷ�"+b);
		System.out.println("��ʼ"+c+"����"+d);
	}
}
