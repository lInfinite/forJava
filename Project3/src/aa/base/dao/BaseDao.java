package aa.base.dao;
/**
 * ����ʵ����������
 * ����ʵ���������ֶ������ֶ�ֵ��������
 * */
import java.util.List;

public interface BaseDao {
    
    public List selectAll(String ClassName);
    public List selectCriteria(String ClassName,String[] ValueName, Object[] value);
    public List selectForPage(String ClassName,int page);
    public List selectForPageAndCriteria(String ClassName,int page,String[] ValueName, Object[] value);
    
}
