package com.wotrd.perscription.service;

import com.wotrd.perscription.pojo.TemapleParam;
import com.wotrd.perscription.pojo.Template;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TemplateService {

    List<Template> queryTemplatePage(TemapleParam temapleParam);

    boolean templateAdd(Integer nid,Integer tid)throws Exception;
}
