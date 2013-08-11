package aa.uitl;
/**
 * sessionfactory工厂
 * 和将字段名字和字段内容数组生成一条以‘and’连接的字符串用于hql查找内容
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class StaticHibernate {
    public final static int maxPage=5;
    
    public static SessionFactory getSessionFactory(){
	    try{	
	    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			SessionFactory session_factory = (SessionFactory)context.getBean("sessionFactory");
			return session_factory;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}
    	
    }
    
    public static String changeHQL(String[] ValueName){
    	int len = ValueName.length;
    	String hql ="";
	    
    	for(int i=0;i<len;i++){
    		
    		if(i<len-1){
        		String str = ValueName[i]+"=:"+ValueName[i]+" and ";
    		    hql = hql+str;
    		}else if(i==len-1){
    		    String str=ValueName[i]+"=:"+ValueName[i];
    		    hql=hql+str;
    		}
    	}
    	return hql;
    }
    
    public static int nextPage(int page){
    	return page+maxPage;
    }
    
    
    public static String getNowTime(){
    	Date date=new Date();
    	String now = new SimpleDateFormat("yyyy-MM-dd").format(date);
    	return now;
    }

    
   public static String ClobToString(Clob clob){
	   String reString = "";
       Reader is = null;
       try {
           is = clob.getCharacterStream();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       BufferedReader br = new BufferedReader(is);
       String s = null;
       try {
           s = br.readLine();
       } catch (IOException e) {
           e.printStackTrace();
       }
       StringBuffer sb = new StringBuffer();
       while (s != null) {
           sb.append(s);
           try {
               s = br.readLine();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       reString = sb.toString();
       return reString;
   }
}
