package com.ropu.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.dao.BaseDao;
import com.ropu.base.dao.SQLTemplate;
import com.ropu.entity.ApplyFlow;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:41
 */
public interface ApplyFlowDao extends BaseDao<ApplyFlow> {
    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public ApplyFlow selectById(ApplyFlow object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<ApplyFlow> selectOr(ApplyFlow object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<ApplyFlow> selectAnd(ApplyFlow object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<ApplyFlow> selectOrLike(ApplyFlow object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<ApplyFlow> selectAndLike(ApplyFlow object, PageBounds page);
}
