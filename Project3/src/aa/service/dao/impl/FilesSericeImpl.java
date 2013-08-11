package aa.service.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import aa.base.dao.impl.BaseImpl;
import aa.entity.Files;
import aa.service.dao.FilesSericeDao;
import aa.uitl.StaticHibernate;
import java.sql.Blob;
import java.sql.SQLException;

public class FilesSericeImpl implements FilesSericeDao {
	
    private BaseImpl baseImpl;
	private FileInputStream fis = null;
	private Session session = null;
	private Transaction t = null;
	
    @Override
	public void saveFiles(Files file) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
		    session.save(file);
		    t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}

    @Override
	public Files createFiles(int file_id) {
    	String[] ValueName = {"file_id"};
    	Object[] value = {file_id};
    	baseImpl.selectCriteria("Files", ValueName, value);
		return null;
	}
 
    
	@Override
	public void deleteFiles(Files file) {
		try{
			session = StaticHibernate.getSessionFactory().getCurrentSession();
			t = session.beginTransaction();
			session.delete(file);
			t.commit();
		}catch(HibernateException he){
			t.rollback();
			he.printStackTrace();
		}
	}


	@Override
	public void output(byte[] b,String name) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(name);
			fos.write(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

    
    @Override
	public byte[] changeBytes(File upload){
		try{
			fis =  new FileInputStream(upload);
			int size = fis.available();
			byte[] b = new byte[size];
			fis.read(b, 0, size);
			fis.close();
			return b;
	    }catch(FileNotFoundException e){
			e.printStackTrace();
			return null;
		}catch(IOException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				fis.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
     * getter and setter
     * */
    public BaseImpl getBaseImpl() {
		return baseImpl;
	}

	public void setBaseImpl(BaseImpl baseImpl) {
		this.baseImpl = baseImpl;
	}
    

    
}
