package com.wotrd.data.dao;

import com.wotrd.data.pojo.Newlyopened;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewlyopenedDao {
    /**
     * 保存就诊记录
     * @param newlyopened
     * @return
     */
    boolean newlyopenedSave(Newlyopened newlyopened)throws Exception;
}
