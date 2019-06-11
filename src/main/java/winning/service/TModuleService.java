package winning.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;
import winning.bean.TModule;
import winning.dao.TModuleDao;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */
@Service
public class TModuleService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource
    private TModuleDao tModuleDao;

    @Transactional
    public Map getAllModules(Map<String, String> paramMap) {

        Map map=new LinkedCaseInsensitiveMap();
        List<Map> list =  tModuleDao.getAllModules();
        map.put("MODULE_LIST", list);
        return map;
    }

    @Transactional
    public Map insertModule(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();
        TModule module = new TModule();
        module.setTmName(paramMap.get("TMNAME"));
        int a = tModuleDao.insertModule(module);

        String msg = a > 0? "保存成功" : "保存失败";
        map.put("IS_EXIST", msg);
        return map;
    }


    @Transactional
    public Map updateModule(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();
        TModule module = new TModule();
        module.setTmName(paramMap.get("TMNAME"));
        module.setTmId(paramMap.get("TMID"));
        int a = tModuleDao.updateModule(module);

        String msg = a > 0? "修改成功" : "修改失败";
        map.put("IS_EXIST", msg);
        return map;
    }

    @Transactional
    public Map deleteModuleById(Map<String, String> paramMap){

        Map map=new LinkedCaseInsensitiveMap();
        int a = tModuleDao.deleteModuleById(new BigDecimal(paramMap.get("TMID")));

        String msg = a > 0? "删除成功" : "删除失败";
        map.put("IS_EXIST", msg);
        return map;
    }


}
