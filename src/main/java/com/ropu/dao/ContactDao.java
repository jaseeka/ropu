package com.ropu.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.base.dao.BaseDao;
import com.ropu.base.dao.SQLTemplate;
import com.ropu.entity.Contact;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 17:47
 */
public interface ContactDao extends BaseDao<Contact>{

    /**
     * 通用id查询操作
     * @param object
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectById")
    public Contact selectById(Contact object);

    /**
     * 通用多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOr")
    public PageList<Contact> selectOr(Contact object, PageBounds page);

    /**
     * 通用多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAnd")
    public PageList<Contact> selectAnd(Contact object, PageBounds page);

    /**
     * 通用like多条件or查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectOrLike")
    public PageList<Contact> selectOrLike(Contact object, PageBounds page);

    /**
     * 通用like多条件and查询操作
     * @param object
     * @param page
     * @return
     */
    @SelectProvider(type = SQLTemplate.class, method = "selectAndLike")
    public PageList<Contact> selectAndLike(Contact object, PageBounds page);

}
