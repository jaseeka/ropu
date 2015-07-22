package com.ropu.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.dao.ProductDao;
import com.ropu.entity.Product;
import com.ropu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:19
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 获取产品列表
     * @param product
     * @param page
     * @return
     */
    @Override
    public PageList<Product> getProductList(Product product, Page page){
        if (product == null){
            product = new Product();
        }
        if (page == null) {
            page = new Page();
        }
        PageList<Product> productPageList = productDao.selectAndLike(product, page.gainPageBounds());

        return productPageList;
    }

    /**
     * 添加产品
     * @param product
     * @return
     */
    @Override
    public Boolean addProduct(Product product){
        if (product == null){
            return false;
        }
        Integer result = productDao.insert(product);

        return result > 0 ? true : false;
    }

    /**
     * 修改产品
     * @param product
     * @return
     */
    @Override
    public Boolean updateProduct(Product product){
        if (product == null || product.getId() == null || product.getId() <= 0){
            return false;
        }
        Integer result = productDao.update(product);

        return result > 0 ? true : false;
    }

    /**
     * 删除产品
     * @param id
     * @return
     */
    public Boolean deleteProductById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Product product = new Product();
        product.setId(id);
        Integer result = productDao.deleteById(product);

        return result > 0 ? true : false;
    }
}
