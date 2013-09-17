package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;

public class UtilForMe {
    //sha1
    public static String eccryptForSHA1(String str){
    	str = DigestUtils.sha1Hex(str);
    	return str;
    }
    
	//系统时间
    public static String systemTime(){
    	Date date=new Date();
    	String dt = new String(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
    	String now = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
    	return now;
    }
    
}
