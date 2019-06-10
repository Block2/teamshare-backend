package winning.service;

import winning.bean.Article;
import winning.dao.ArticleDao;
import winning.util.JsonUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
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

        Map map = new LinkedCaseInsensitiveMap();
        List<Map> list = articleDao.getArticlesByMcid(new BigDecimal(paramMap.get("MCID")));
        map.put("ARTICLE_LIST", list);
        return map;
    }

    @Transactional
    public Map insertArticle(Map<String, String> paramMap) {

        Map map = new LinkedCaseInsensitiveMap();
        Article article = new Article();
        int a = 0;
        try {
            if (!isUndefined(paramMap.get("TITLE"))) {
                article.setTitle(paramMap.get("TITLE"));
            }
            if (!isUndefined(paramMap.get("AUTHOR"))) {
                article.setAuthor(paramMap.get("AUTHOR"));
            }
            if (!isUndefined(paramMap.get("TAG"))) {
                article.setTag(paramMap.get("TAG"));
            }
            if (!isUndefined(paramMap.get("BODYPART"))) {
                article.setBodypart(paramMap.get("BODYPART").getBytes("utf8"));
            }
            if (!isUndefined(paramMap.get("CREATETIME"))) {
                article.setCreateTime(paramMap.get("CREATETIME"));
            }
            if (!isUndefined(paramMap.get("MCID"))) {
                article.setMcId(new BigDecimal(paramMap.get("MCID")));
            }

            if(!isUndefined(paramMap.get("AID"))){
                article.setaId(new BigDecimal(paramMap.get("AID")));
                a = articleDao.updateArticle(article);
            }else{
                a = articleDao.insertArticle(article);
            }


        } catch (UnsupportedEncodingException e) {
            a = 0;
        }

        String msg = a > 0 ? "保存成功" : "保存失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map updateArticle(Map<String, String> paramMap) {

        Map map = new LinkedCaseInsensitiveMap();

        Article article = JsonUtils.jsonStrToBean("ARTICLE", Article.class);
        int a = articleDao.updateArticle(article);

        String msg = a > 0 ? "修改成功" : "修改失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map getArticleById(Map<String, String> paramMap) {

        if (isUndefined(paramMap.get("AID"))) {
            return null;
        }
        Map map = articleDao.getArticleById(new BigDecimal(paramMap.get("AID")));
        if(map.get("BODYPART") != null) {
            byte[] bodyPart = (byte[]) map.get("BODYPART");
            if(bodyPart.length != 0) {
                try {
                    String bodyPartStr = new String(bodyPart, "utf8");
                    map.put("BODYPART", bodyPartStr);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

            }
        }
        return map;
    }

    @Transactional
    public Map deleteArticle(Map<String, String> paramMap) {

        Map map = new LinkedCaseInsensitiveMap();

        int a = articleDao.deleteArticleById(new BigDecimal(paramMap.get("AID")));

        String msg = a > 0 ? "删除成功" : "删除失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    private boolean isUndefined(String str) {
        return str == null || "".equals(str.trim()) || str.trim().equals("undefined");
    }


}
