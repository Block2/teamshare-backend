package winning.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import winning.service.CommonService;
import winning.util.RequestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by xwf on 2019/6/4.
 */

@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private CommonService commonService;

    @RequestMapping("/getPathInfo")
    public Map insertArticle(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return commonService.getPathInfo(paramMap);
    }

}
