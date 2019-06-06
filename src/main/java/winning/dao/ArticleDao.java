package winning.dao;

import winning.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface ArticleDao {

    List<Map> getArticlesByMcid(@Param("mcid") BigDecimal mcid);
    Map getArticleById(@Param("id") BigDecimal id);
    int updateArticle(Article article);
    int deleteArticleById(@Param("id") BigDecimal id);
    int insertArticle(Article article);

}
