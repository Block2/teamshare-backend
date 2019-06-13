package winning.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;
import winning.bean.MColumn;
import winning.dao.MColumnDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */
@Service
public class MColumnService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private MColumnDao mColumnDao;

    @Transactional
    public Map getColumnById(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        return mColumnDao.getColumnById(new BigDecimal(paramMap.get("MCID")));
    }


//    @Transactional
//    public Map getColumnsByTmid(Map<String, String> paramMap) {
//
//        Map map=new LinkedCaseInsensitiveMap();
//        List<Map> columnList = new ArrayList<Map>();
//
//        List<Map> list =  mColumnDao.getColumnsByTmid(new BigDecimal(paramMap.get("TMID")));
//
//        if(list != null && !list.isEmpty()){
//
//            for(Map column : list) {
//
//                Map columnMap = new HashMap();
//                //将MCID转成String类型
//                column.put("MCID",((BigDecimal)column.get("MCID")).toString());
//                List<Map> articles = mColumnDao.getArticlesByMcid(new BigDecimal((String)column.get("MCID")));
//                if(articles != null && !articles.isEmpty()) {
//                    for(Map article : articles){
//                        //将AID转成String类型
//                        article.put("AID", ((BigDecimal)article.get("AID")).toString());
//                    }
//                    columnMap.put("ARTICLE_LIST", articles);
//                }
//                columnMap.put("COLUMN", column);
//                columnList.add(columnMap);
//            }
//        }
//
//        map.put("COLUMN_LIST", columnList);
//        return map;
//    }


    @Transactional
    public Map getColumnsByTmid(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        List<Map> columnList = new ArrayList<Map>();

        List<Map> list =  mColumnDao.getColumnsByTmid(new BigDecimal(paramMap.get("TMID")));

        if(list != null && !list.isEmpty()){

            for(Map column : list) {
                Map columnMap = new HashMap();
                List<Map> articles = mColumnDao.getArticlesByMcid((BigDecimal) column.get("MCID"));
                if(articles != null && !articles.isEmpty()) {
                    List<Map> articleList = new ArrayList<Map>();
                    for(Map article : articles){
                        //将AID转成String类型
                        article.put("id", ((BigDecimal)article.get("AID")).toString());
                        article.put("label", (String)article.get("TITLE"));
                        articleList.add(article);
                    }
                    columnMap.put("children", articleList);
                }
                columnMap.put("label", column.get("MCNAME"));
                columnMap.put("id", ((BigDecimal)column.get("MCID")).toString());
                columnList.add(columnMap);
            }
        }

        map.put("COLUMN_LIST", columnList);
        return map;
    }

    @Transactional
    public Map updateColumn(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        MColumn column = new MColumn();
        column.setMcName(paramMap.get("MCNAME"));
        column.setTmId(new BigDecimal(paramMap.get("TMID")));
        column.setMcId(new BigDecimal(paramMap.get("MCID")));
        column.setMcComment(paramMap.get("MCCOMMENT"));

        int a =  mColumnDao.updateColumn(column);

        String msg = a > 0? "修改成功" : "修改失败";
        map.put("IS_EXIST", msg);
        return map;
    }


    @Transactional
    public Map deleteColumnById(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        int a =  mColumnDao.deleteColumnById(new BigDecimal(paramMap.get("MCID")));

        String msg = a > 0? "删除成功" : "删除失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map insertColumn(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        MColumn column = new MColumn();
        column.setMcName(paramMap.get("MCNAME"));
        column.setTmId(new BigDecimal(paramMap.get("TMID")));
        column.setMcComment(paramMap.get("MCCOMMENT"));
        int a =  mColumnDao.insertColumn(column);

        String msg = a > 0? "保存成功" : "保存失败";
        map.put("IS_EXIST", msg);
        return map;
    }

}
