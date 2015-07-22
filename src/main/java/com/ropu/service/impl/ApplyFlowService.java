package com.ropu.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.dao.ApplyFlowDao;
import com.ropu.entity.ApplyFlow;
import com.ropu.service.IApplyFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:44
 */
@Service
public class ApplyFlowService implements IApplyFlowService {

    @Autowired
    private ApplyFlowDao applyFlowDao;

    /**
     * 获取申请列表
     * @param applyFlow
     * @param page
     * @return
     */
    @Override
    public PageList<ApplyFlow> getApplyFlowList(ApplyFlow applyFlow, Page page){
        if (applyFlow == null){
            applyFlow = new ApplyFlow();
        }
        if (page == null){
            page = new Page();
        }
        PageList<ApplyFlow> applyFlowPageList = applyFlowDao.selectAndLike(applyFlow, page.gainPageBounds());

        return applyFlowPageList;
    }

    /**
     * 添加申请
     * @param applyFlow
     * @return
     */
    @Override
    public Boolean addApplyFlow(ApplyFlow applyFlow){
        if (applyFlow == null){
            return false;
        }
        Integer result = applyFlowDao.insert(applyFlow);

        return result > 0 ? true : false;
    }

    /**
     * 修改申请
     * @param applyFlow
     * @return
     */
    @Override
    public Boolean updateApplyFlow(ApplyFlow applyFlow){
        if (applyFlow == null || applyFlow.getId() == null || applyFlow.getId() <= 0){
            return false;
        }
        Integer result = applyFlowDao.update(applyFlow);

        return result > 0 ? true : false;
    }

    /**
     * 删除申请
     * @param id
     * @return
     */
    @Override
    public Boolean deleteApplyFlowById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        ApplyFlow applyFlow = new ApplyFlow();
        applyFlow.setId(id);
        Integer result = applyFlowDao.deleteById(applyFlow);

        return result > 0 ? true : false;
    }
}
