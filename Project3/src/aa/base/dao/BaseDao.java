package aa.base.dao;
/**
 * 根据实体类名超找
 * 根据实体类名和字段名和字段值查找内容
 * */
import java.util.List;

public interface BaseDao {
    
    public List selectAll(String ClassName);
    public List selectCriteria(String ClassName,String[] ValueName, Object[] value);
    public List selectForPage(String ClassName,int page);
    public List selectForPageAndCriteria(String ClassName,int page,String[] ValueName, Object[] value);
    
}
