package winning.dao;

import winning.bean.MColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface MColumnDao {

    Map getColumnById(@Param("id") BigDecimal id);
    List<Map>  getColumnsByTmid(@Param("tmid") BigDecimal tmid);
    int updateColumn(MColumn column);
    int deleteColumnById(@Param("id") BigDecimal id);
    int insertColumn(MColumn column);
    List<Map> getArticlesByMcid(@Param("mcid") BigDecimal mcid);
}
