package com.wotrd.data.service;

import com.wotrd.data.pojo.Savejiancha;

import java.util.List;

public interface SavejianchaService {
    boolean savejancha(List<Savejiancha> savejianchas)throws Exception;
}
