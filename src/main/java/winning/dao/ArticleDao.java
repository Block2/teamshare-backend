package winning.dao;

import winning.bean.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface ArticleDao {

    List<Map> getArticlesByMcid(@Param("mcid") String mcid);
    Map getArticleById(@Param("id") String id);
    int updateArticle(Article article);
    int deleteArticleById(@Param("id") String id);
    int insertArticle(Article article);

}
