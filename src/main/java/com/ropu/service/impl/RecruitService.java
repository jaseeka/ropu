package com.ropu.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.dao.RecruitDao;
import com.ropu.entity.Recruit;
import com.ropu.service.IRecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:30
 */
@Service
public class RecruitService implements IRecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 获取招聘列表
     * @param recruit
     * @param page
     * @return
     */
    @Override
    public PageList<Recruit> getRecruitList(Recruit recruit, Page page){
        if (recruit == null){
            recruit = new Recruit();
        }
        if (page == null){
            page = new Page();
        }
        PageList<Recruit> recruitPageList = recruitDao.selectAndLike(recruit, page.gainPageBounds());

        return recruitPageList;
    }

    /**
     * 添加招聘
     * @param recruit
     * @return
     */
    public Boolean addRecruit(Recruit recruit){
        if (recruit == null){
            return false;
        }
        Integer result = recruitDao.insert(recruit);

        return result > 0 ? true : false;
    }

    /**
     * 修改招聘
     * @param recruit
     * @return
     */
    public Boolean updateRecruit(Recruit recruit){
        if (recruit == null || recruit.getId() == null || recruit.getId() <= 0){
            return false;
        }
        Integer result = recruitDao.update(recruit);

        return result > 0 ? true : false;
    }

    /**
     * 删除招聘
     * @param id
     * @return
     */
    public Boolean deleteRecruitById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Recruit recruit = new Recruit();
        recruit.setId(id);
        Integer result = recruitDao.deleteById(recruit);

        return result > 0 ? true : false;
    }
}
