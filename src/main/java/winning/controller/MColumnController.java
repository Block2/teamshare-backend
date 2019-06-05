package winning.controller;

import winning.service.MColumnService;
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
@RequestMapping("/column")
public class MColumnController {

    @Resource
    private MColumnService mColumnService;

    @RequestMapping("/getColumnById")
    public Map getColumnById(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return mColumnService.getColumnById(paramMap);
    }

    @RequestMapping("/getColumnsByTmid")
    public Map getColumnsByTmid(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return mColumnService.getColumnsByTmid(paramMap);
    }

    @RequestMapping("/updateColumn")
    public Map updateColumn(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return mColumnService.updateColumn(paramMap);
    }

    @RequestMapping("/deleteColumnById")
    public Map deleteColumnById(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return mColumnService.deleteColumnById(paramMap);
    }

    @RequestMapping("/insertColumn")
    public Map insertColumn(HttpServletRequest request){

        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return mColumnService.insertColumn(paramMap);
    }


}
