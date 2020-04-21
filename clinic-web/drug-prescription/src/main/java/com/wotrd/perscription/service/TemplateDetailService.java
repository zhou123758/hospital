package com.wotrd.perscription.service;

import com.wotrd.perscription.pojo.Templatedetail;

import java.util.List;

public interface TemplateDetailService {
    /**
     * 处方详情
     * @return
     */
    List<Templatedetail> Templatedetail(Long tempateId);

    /**
     * 处方详情添加
     * @param templatedetail
     * @return
     * @throws Exception
     */
    boolean temaplateAdd(Templatedetail templatedetail)throws Exception;
}
