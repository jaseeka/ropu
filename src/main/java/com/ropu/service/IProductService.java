package com.ropu.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.entity.Product;
import org.aspectj.weaver.patterns.PerObject;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:19
 */
public interface IProductService {
    /**
     * 获取产品列表
     * @param product
     * @param page
     * @return
     */
    public PageList<Product> getProductList(Product product, Page page);

    /**
     * 添加产品
     * @param product
     * @return
     */
    public Boolean addProduct(Product product);

    /**
     * 修改产品
     * @param product
     * @return
     */
    public Boolean updateProduct(Product product);

    /**
     * 删除产品
     * @param id
     * @return
     */
    public Boolean deleteProductById(Integer id);
}
