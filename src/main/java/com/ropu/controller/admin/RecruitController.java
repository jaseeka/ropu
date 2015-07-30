package com.ropu.controller.admin;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.utils.HtmlUtils;
import com.ropu.common.Page;
import com.ropu.common.ResultCode;
import com.ropu.common.ResultEntity;
import com.ropu.common.TypeEnum;
import com.ropu.entity.Product;
import com.ropu.entity.Recruit;
import com.ropu.service.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jaseeka
 * date 2015/7/23
 * time 9:34
 */
@Controller
@RequestMapping("/admin")
public class RecruitController extends BaseWebController {

    @Autowired
    private IRecruitService recruitService;

    /**
     * 页面跳转
     * @param request
     * @return
     */
    @RequestMapping(value = "/recruit")
    public ModelAndView main(Integer type, HttpServletRequest request){
        Map<String, Object> context = getRootMap(request);
        if (TypeEnum.LanguageEnum.CN.ordinal() == type){
            return forword("admin/recruit_cn", context);
        } else if (TypeEnum.LanguageEnum.EN.ordinal() == type){
            return forword("admin/recruit_cn", context);
        }
        return forword("admin/recruit_cn", context);
    }

    /**
     * 列表
     * @param model
     * @param response
     * @param page
     * @param rows
     * @param pageSort
     * @param pageOrder
     */
    @RequestMapping(value = "recruitList")
    public void productList(
            Recruit model,
            HttpServletResponse response,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer rows,
            @RequestParam(required = false) String pageSort,
            @RequestParam(required = false) String pageOrder
    ){
        // 分页信息封装
        Page pages = new Page(page, rows, pageSort, pageOrder);
        // 获取信息
        PageList<Recruit> recruitPageList = recruitService.getRecruitList(model, pages);
        if (recruitPageList != null || recruitPageList.size() > 0) {
            pages.setTotal(recruitPageList.getPaginator().getTotalCount());
        }
        //设置页面数据
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", pages.getTotal());
        jsonMap.put("rows", recruitPageList);
        HtmlUtils.writerJson(response, jsonMap);
    }

    /**
     * 添加或修改
     * @param model
     * @param response
     */
    @RequestMapping(value = "saveRecruit")
    public void saveRecruit(
            Recruit model,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        if (model == null){
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }
        Boolean result = false;
        if (model.getId() == null || model.getId() <= 0){
            result = recruitService.addRecruit(model);
        } else {
            result = recruitService.updateRecruit(model);
        }

        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        HtmlUtils.writerJson(response, resultEntity);
    }

    /**
     * 删除
     * @param id
     * @param response
     */
    @RequestMapping(value = "deleteRecruit")
    public void deleteRecruit(
            @RequestParam(value = "id") Integer id,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        if (id == null){
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }
        Boolean result = recruitService.deleteRecruitById(id);

        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        HtmlUtils.writerJson(response, resultEntity);
    }
}
