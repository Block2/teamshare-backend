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
        if(!isUndefined(paramMap.get("AID"))){
            result = commonDao.getPathInfoByAid(new BigDecimal(paramMap.get("AID")));
        } else if(!isUndefined(paramMap.get("MCID"))) {
            result = commonDao.getPathInfoByMcid(new BigDecimal(paramMap.get("MCID")));
        }
        if(result==null || result.isEmpty()){
            map.put("pathInfo", "不合法的路径");
        }else{
            map.put("pathInfo", result);
        }
        return map;
    }

    private boolean isUndefined(String str) {
        return str == null || "".equals(str.trim()) || str.trim().equals("undefined");
    }

}
