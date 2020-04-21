package com.wotrd.data.dao;

import com.wotrd.data.pojo.Checkitem;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface CheckitemDao {
    /**
     * 检查项目分页查询
     * @return
     */
    List<Checkitem> queryCheckitemParamPage(Map<String,Object> param);

    boolean checkitemAdd(@Param("pid") Integer pid, @Param("cid")Integer cid)throws Exception;
}
