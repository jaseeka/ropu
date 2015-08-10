package com.ropu.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.dao.BaseDao;
import com.ropu.base.dao.SQLTemplate;
import com.ropu.entity.Price;
import org.apache.ibatis.annotations.SelectProvider;


/**
 * Created by jaseeka
 * Date 2015/8/10
 * Time 23:48
 */
public interface PriceDao extends BaseDao<Price>{
    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public Price selectById(Price object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<Price> selectOr(Price object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<Price> selectAnd(Price object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<Price> selectOrLike(Price object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<Price> selectAndLike(Price object, PageBounds page);
}
