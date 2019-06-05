package winning.dao;

import winning.bean.MColumn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface MColumnDao {

    Map getColumnById(@Param("id") String id);
    List<Map>  getColumnsByTmid(@Param("tmid") String tmid);
    int updateColumn(MColumn column);
    int deleteColumnById(@Param("id") String id);
    int insertColumn(MColumn column);
    List<Map> getArticlesByMcid(@Param("mcid") String mcid);
}
