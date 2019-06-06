package winning.dao;

import winning.bean.TModule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface TModuleDao {

    List<Map> getAllModules();
    int deleteModuleById(@Param("id") BigDecimal id);
    int insertModule(TModule moudle);
    int updateModule(TModule module);
}
