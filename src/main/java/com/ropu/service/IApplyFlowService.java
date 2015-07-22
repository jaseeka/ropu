package com.ropu.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.entity.ApplyFlow;
import com.ropu.entity.Product;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:44
 */
public interface IApplyFlowService {
    /**
     * 获取申请列表
     * @param applyFlow
     * @param page
     * @return
     */
    public PageList<ApplyFlow> getApplyFlowList(ApplyFlow applyFlow, Page page);

    /**
     * 添加申请
     * @param applyFlow
     * @return
     */
    public Boolean addApplyFlow(ApplyFlow applyFlow);

    /**
     * 修改申请
     * @param applyFlow
     * @return
     */
    public Boolean updateApplyFlow(ApplyFlow applyFlow);

    /**
     * 删除申请
     * @param id
     * @return
     */
    public Boolean deleteApplyFlowById(Integer id);
}
