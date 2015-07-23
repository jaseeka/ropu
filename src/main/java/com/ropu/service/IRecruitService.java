package com.ropu.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.entity.Recruit;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:30
 */
public interface IRecruitService {
    /**
     * 获取招聘列表
     * @param recruit
     * @param page
     * @return
     */
    public PageList<Recruit> getRecruitList(Recruit recruit, Page page);

    /**
     * 添加招聘
     * @param recruit
     * @return
     */
    public Boolean addRecruit(Recruit recruit);

    /**
     * 修改招聘
     * @param recruit
     * @return
     */
    public Boolean updateRecruit(Recruit recruit);

    /**
     * 删除招聘
     * @param id
     * @return
     */
    public Boolean deleteRecruitById(Integer id);
}
