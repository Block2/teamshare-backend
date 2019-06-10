package winning.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;
import winning.dao.CommonDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */
@Service
public class CommonService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private CommonDao commonDao;

    @Transactional
    public Map getPathInfo(Map<String, String> paramMap) {

        Map map = new LinkedCaseInsensitiveMap();
        Map result = new HashMap();
        if(paramMap.get("AID") != null && !paramMap.get("AID").equals("")){
            result = commonDao.getPathInfoByAid(new BigDecimal(paramMap.get("AID")));
        } else if(paramMap.get("MCID") != null && !paramMap.get("MCID").equals("")) {
            result = commonDao.getPathInfoByAid(new BigDecimal(paramMap.get("MCID")));
        }
        if(result.isEmpty()){
            map.put("pathInfo", "不合法的路径");
        }else{
            map.put("pathInfo", result);
        }
        return map;
    }

    @Transactional
    public Map getPathInfoByAid(Map<String, String> paramMap) {

        Map map = new LinkedCaseInsensitiveMap();
        Map list = commonDao.getPathInfoByAid(new BigDecimal(paramMap.get("MCID")));
        map.put("pathinfo", list);
        return map;
    }

}
