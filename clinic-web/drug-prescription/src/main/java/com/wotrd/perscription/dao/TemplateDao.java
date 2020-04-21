package com.wotrd.perscription.dao;

import com.wotrd.perscription.pojo.Template;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

@Mapper
public interface TemplateDao {
    List<Template> queryTemplatePage(Map<String,Object> param);

    boolean templateAdd(@Param("nid")Integer nid,@Param("tid")Integer tid)throws Exception;
}
