package com.wotrd.data.service;

import com.wotrd.data.pojo.Checkitem;
import com.wotrd.data.pojo.CheckitemParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CheckitemService {
    /**
     * 检查项目分页查询
     * @return
     */
    List<Checkitem> queryCheckitemParamPage(CheckitemParam checkitemParam);

    boolean checkitemAdd(Integer pid,Integer cid)throws Exception;
}
