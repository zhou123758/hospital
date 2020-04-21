package com.wotrd.perscription.temaplecontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wotrd.perscription.pojo.TemapleParam;
import com.wotrd.perscription.pojo.Template;
import com.wotrd.perscription.pojo.Templatedetail;
import com.wotrd.perscription.service.TemplateDetailService;
import com.wotrd.perscription.service.TemplateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.wotrd.pojo.utils.RequesBean;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temaple")
public class TempleController {
    @Autowired
    TemplateService templateService;
    @Autowired
    TemplateDetailService templateDetailService;
    @ApiOperation(value = "处方模板查询",notes = "处方模板信息分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageIndex",
            value = "当前页数，必填",required = true,defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "prescriptionId",
            value = "处方类型编号 数值类型,1:西/成药处方，2:中药处方，3:检查项目"),
            @ApiImplicitParam(paramType = "query",name = "permissionId",
            value = "模板权限编号 数值类型，1:私人模板，2:公共模板"),
            @ApiImplicitParam(paramType = "query",name = "tempNameORtempId",
            value = "模板名称或模板编号")
    })
    @GetMapping("/queryTemaplePage")
    public RequesBean queryTemaplePage(@RequestParam(value = "pageIndex",defaultValue = "1")String pageIndex,
                                       TemapleParam temapleParam){
        try {
            if(temapleParam.getPermissionId().equals("null")){
                temapleParam.setPermissionId("");
            }
            if(temapleParam.getPrescriptionId().equals("null")){
                temapleParam.setPrescriptionId("");
            }
            if(temapleParam.getTempNameORtempId().equals("null")){
                temapleParam.setTempNameORtempId("");
            }
            PageHelper.startPage(Integer.parseInt(pageIndex),3);
            List<Template> templates = templateService.queryTemplatePage(temapleParam);
            PageInfo<Template> templatePageInfo = new PageInfo<Template>(templates);
            return RequesBean.ok(templatePageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }
    @ApiOperation(value = "模板详情",notes = "根据模板编号查看详情")
    @ApiImplicitParam(paramType = "path",name = "id",value = "模板编号必填",required = true,defaultValue = "1")
    @GetMapping("/Temaplebyid/{id}")
    public RequesBean templateDetail(@PathVariable("id") String id){
        try {
            List<Templatedetail> templatedetails =
                    templateDetailService.Templatedetail(Long.parseLong(id));
            return RequesBean.ok(templatedetails);
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("系统异常",e);
        }
    }
//    @GetMapping("/templateadd")
//    public RequesBean templateAdd(@RequestParam("nid")Integer nid, @RequestParam("tid")Integer tid){
//        try {
//            boolean flag = templateService.templateAdd(nid,tid);
//            if(flag){
//                return RequesBean.ok("处方检查项目保存成功");
//            }else{
//                return RequesBean.error("处方检查项目保存失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return RequesBean.error("处方检查项目保存系统异常",e.getMessage());
//        }
//    }

    @GetMapping("/temaplateadd")
    public RequesBean temaplateAdd(Templatedetail templatedetail){
        try {
            boolean flag = templateDetailService.temaplateAdd(templatedetail);
            if(flag){
                return RequesBean.ok("保存处方药品成功",templatedetail.getId());
            }else{
                return RequesBean.error("保存处方药品失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return RequesBean.error("保存处方药品系统异常",e.getMessage());
        }
    }
}
