package com.ropu.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.dao.CompanyDao;
import com.ropu.entity.Company;
import com.ropu.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 15:24
 */
@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyDao companyDao;

    /**
     * 获取公司列表
     * @param company
     * @param page
     * @return
     */
    @Override
    public PageList<Company> getCompanyList(Company company, Page page){
        if (company == null){
            company = new Company();
        }
        if (page == null){
            page = new Page();
        }
        PageList<Company> companyPageList = companyDao.selectAndLike(company,page.gainPageBounds());

        return companyPageList;
    }

    /**
     * 添加公司
     * @param company
     * @return
     */
    @Override
    public Boolean addCompany(Company company){
        if (company == null){
            return false;
        }
        Integer result = companyDao.insert(company);

        return result > 0 ? true : false;
    }

    /**
     * 修改公司
     * @param company
     * @return
     */
    @Override
    public Boolean updateCompany(Company company){
        if (company == null || company.getId() == null || company.getId() <= 0){
            return false;
        }
        Integer result = companyDao.update(company);

        return result > 0 ? true : false;
    }

    /**
     * 删除公司
     * @param id
     * @return
     */
    @Override
    public Boolean deleteCompanyById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Company company = new Company();
        company.setId(id);
        Integer result = companyDao.deleteById(company);

        return result > 0 ? true : false;
    }
}
