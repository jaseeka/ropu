package com.ropu.controller.admin;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.utils.HtmlUtils;
import com.ropu.common.Page;
import com.ropu.common.ResultCode;
import com.ropu.common.ResultEntity;
import com.ropu.entity.ApplyFlow;
import com.ropu.entity.Product;
import com.ropu.service.IApplyFlowService;
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
 * date 2015/7/22
 * time 20:41
 */
@Controller
@RequestMapping("/admin")
public class ApplyFlowController extends BaseWebController {

    @Autowired
    private IApplyFlowService applyFlowService;

    /**
     * 页面跳转
     * @param request
     * @return
     */
    @RequestMapping(value = "/applyFlow")
    public ModelAndView main(HttpServletRequest request){
        Map<String, Object> context = getRootMap(request);
        return forword("admin/applyFlow", context);
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
    @RequestMapping(value = "applyFlowList")
    public void applyFlowList(
            ApplyFlow model,
            HttpServletResponse response,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer rows,
            @RequestParam(required = false) String pageSort,
            @RequestParam(required = false) String pageOrder
    ){
        // 分页信息封装
        Page pages = new Page(page, rows, pageSort, pageOrder);
        // 获取信息
        PageList<ApplyFlow> applyFlowList = applyFlowService.getApplyFlowList(model, pages);
        if (applyFlowList != null || applyFlowList.size() > 0) {
            pages.setTotal(applyFlowList.getPaginator().getTotalCount());
        }
        //设置页面数据
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("total", pages.getTotal());
        jsonMap.put("rows", applyFlowList);
        HtmlUtils.writerJson(response, jsonMap);
    }

    /**
     * 添加或修改
     * @param model
     * @param response
     */
    @RequestMapping(value = "saveApplyFlow")
    public void saveApplyFlow(
            ApplyFlow model,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        if (model == null){
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }
        Boolean result = false;
        if (model.getId() == null || model.getId() <= 0){
            result = applyFlowService.addApplyFlow(model);
        } else {
            result = applyFlowService.updateApplyFlow(model);
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
    @RequestMapping(value = "deleteApplyFlow")
    public void deleteApplyFlow(
            @RequestParam(value = "id") Integer id,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        if (id == null){
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }
        Boolean result = applyFlowService.deleteApplyFlowById(id);

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
