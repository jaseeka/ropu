package com.ropu.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.dao.BaseDao;
import com.ropu.base.dao.SQLTemplate;
import com.ropu.entity.Admin;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 14:51
 */
public interface AdminDao extends BaseDao<Admin> {

    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public Admin selectById(Admin object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<Admin> selectOr(Admin object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<Admin> selectAnd(Admin object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<Admin> selectOrLike(Admin object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<Admin> selectAndLike(Admin object, PageBounds page);
}
