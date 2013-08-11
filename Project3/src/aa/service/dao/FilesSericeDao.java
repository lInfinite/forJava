package aa.service.dao;

import java.io.File;

import aa.entity.Files;

public interface FilesSericeDao {
	public void saveFiles(Files file);
	public void deleteFiles(Files file);
	public byte[] changeBytes(File file);
	/*public byte[] input(Files file);*/
	public void output(byte[] b,String name);
    public Files createFiles(int file_id);
    
}
