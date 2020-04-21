package com.wotrd.clinic.service;

import com.wotrd.clinic.pojo.Drug;
import com.wotrd.pojo.utils.Page;


import java.util.List;

public interface DrugService {

    List<Drug> quertDrugPage(Page page, Long chargettypeid, Long drugstatus, String creationtime,String drugnameordrugnoorvender);

    int quertDrugCount(Page page, Long chargettypeid, Long drugstatus, String creationtime,String drugnameordrugnoorvender);
}
