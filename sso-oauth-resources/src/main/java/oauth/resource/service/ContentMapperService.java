package oauth.resource.service;

import oauth.resource.mapper.ContentMapper;
import oauth.resource.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentMapperService {
    @Autowired
    ContentMapper contentMapper;
    public List<TbUser> queryAllContent(Long categoryId){
        return contentMapper.queryAllContent(categoryId);
    }
}
