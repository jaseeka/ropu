package com.ropu.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.entity.Company;
import com.ropu.entity.Product;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:24
 */
public interface ICompanyService {
    /**
     * 获取公司列表
     * @param company
     * @param page
     * @return
     */
    public PageList<Company> getCompanyList(Company company, Page page);

    /**
     * 添加公司
     * @param company
     * @return
     */
    public Boolean addCompany(Company company);

    /**
     * 修改公司
     * @param company
     * @return
     */
    public Boolean updateCompany(Company company);

    /**
     * 删除公司
     * @param id
     * @return
     */
    public Boolean deleteCompanyById(Integer id);
}
