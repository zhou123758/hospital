package oauth.resource.mapper;

import oauth.resource.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContentMapper {
    @Select("select * from tb_user")
    public List<TbUser>queryAllContent(Long categoryId);
}
