package winning.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;
import winning.bean.MColumn;
import winning.dao.MColumnDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

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

    @Transactional
    public Map getColumnsByTmid(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        List<Map> columnList = new ArrayList<Map>();

        List<Map> list =  mColumnDao.getColumnsByTmid(new BigDecimal(paramMap.get("TMID")));

        if(list != null && !list.isEmpty()){

            for(Map column : list) {
                Map columnMap = new HashMap();
                columnMap.put("label", column.get("MCNAME"));
                columnMap.put("id", ((BigDecimal)column.get("MCID")).toString());
                if(!isUndefined((String)column.get("ROUTE_PATH"))){
                    columnMap.put("route_path", (String)column.get("ROUTE_PATH"));
                }else {
                    List<Map> articles = mColumnDao.getArticlesByMcid((BigDecimal) column.get("MCID"));
                    if (articles != null && !articles.isEmpty()) {
                        List<Map> articleList = new ArrayList<Map>();
                        for (Map article : articles) {
                            //将AID转成String类型
                            article.put("id", ((BigDecimal) article.get("AID")).toString());
                            article.put("label", (String) article.get("TITLE"));
                            articleList.add(article);
                        }
                        columnMap.put("children", articleList);
                    }
                }

                columnList.add(columnMap);
            }
        }

        //对columnList进行排序，将有指定route_path的栏目放置在最后面
        Collections.sort(columnList, new ColumnInfoMapComparator());
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

    private boolean isUndefined(String str) {
        return str == null || "".equals(str.trim()) || str.trim().equals("undefined");
    }

    class ColumnInfoMapComparator implements Comparator {
        public int compare(Object o1, Object o2) {


            Map s1 = (Map) o1;
            Map s2 = (Map) o2;
            if(!isUndefined((String)s2.get("route_path"))){
                return -1;
            }
            return 1;
        }
    }

}
