package com.wotrd.data.dao;

import com.wotrd.data.pojo.Savejiancha;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SavejianchaDao {

    boolean savejancha(Savejiancha savejiancha);
}
