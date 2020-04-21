package oauth.resource.controller;

import oauth.resource.pojo.TbUser;
import oauth.resource.service.ContentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ResourceController {
    @Autowired
    private ContentMapperService contentMapperService;
    @RequestMapping("list")
    public List<TbUser>queryAllContent(@RequestParam("categoryId")Long categoryId){
        return contentMapperService.queryAllContent(categoryId);
    }
}
