package winning.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface CommonDao {

    Map getPathInfoByMcid(@Param("mcid") BigDecimal mcid);
    Map getPathInfoByAid(@Param("aid") BigDecimal aid);

}
