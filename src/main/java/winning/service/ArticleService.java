package winning.service;

import winning.bean.Article;
import winning.dao.ArticleDao;
import winning.util.JsonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */
@Service
public class ArticleService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private ArticleDao articleDao;

    @Transactional
    public Map getArticleByMcid(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        List<Map> list =  articleDao.getArticlesByMcid(paramMap.get("MCID"));
        map.put("ARTICLE_LIST", list);
        return map;
    }

    @Transactional
    public Map insertArticle(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();

        Article article = JsonUtils.jsonStrToBean("ARTICLE", Article.class);
        int a = articleDao.insertArticle(article);

        String msg = a > 0? "保存成功" : "保存失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map updateArticle(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();

        Article article = JsonUtils.jsonStrToBean("ARTICLE", Article.class);
        int a = articleDao.updateArticle(article);

        String msg = a > 0? "修改成功" : "修改失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map getArticleById(Map<String, String> paramMap){
        return articleDao.getArticleById(paramMap.get("AID"));
    }

    @Transactional
    public Map deleteArticle(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();

        int a = articleDao.deleteArticleById(paramMap.get("AID"));

        String msg = a > 0? "删除成功" : "删除失败";
        map.put("IS_EXIST", msg);
        return map;
    }




//    MColumn getColumnById(@Param("id") String id);
//    List<MColumn> getColumnsByTmid(@Param("tmid") String tmid);
//    int updateMoudleById(MColumn column);
//    int deleteMouldeById(@Param("id") String id);
//    int insertColumn(MColumn column);




}
