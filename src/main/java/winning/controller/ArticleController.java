package winning.controller;

import winning.service.ArticleService;
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
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/insertArticle")
    public Map insertArticle(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return articleService.insertArticle(paramMap);
    }

    @RequestMapping("/updateArticle")
    public Map updateArticle(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return articleService.updateArticle(paramMap);
    }

    @RequestMapping("/deleteArticle")
    public Map deleteArticle(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return articleService.deleteArticle(paramMap);
    }

    @RequestMapping("/getArticleByMcid")
    public Map getArticleByMcid(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return articleService.getArticleByMcid(paramMap);
    }

    @RequestMapping("/getArticleById")
    public Map getArticleById(HttpServletRequest request){
        Map<String,String> paramMap= RequestUtils.getRequestParamMap(request);
        return articleService.getArticleById(paramMap);
    }


}
