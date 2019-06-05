package winning.controller;

import winning.service.TModuleService;
import winning.util.RequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */

@RestController
@RequestMapping("/module")
public class TModuleController {

    @Resource
    private TModuleService tModuleService;

    @RequestMapping("/getAllModules")
    public Map getFBMBList(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return tModuleService.getAllModules(paramMap);
    }

    @RequestMapping("/insertModule")
    public Map insertModule(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return tModuleService.insertModule(paramMap);
    }

    @RequestMapping("/deleteModuleById")
    public Map deleteModuleById(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return tModuleService.deleteModuleById(paramMap);
    }

    @RequestMapping("/updateModule")
    public Map updateModule(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return tModuleService.updateModule(paramMap);
    }
}
