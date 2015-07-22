package com.ropu.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.entity.Contact;
import com.ropu.entity.Product;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 17:51
 */
public interface IContactService {
    /**
     * 获取联系列表
     * @param contact
     * @param page
     * @return
     */
    public PageList<Contact> getContactList(Contact contact, Page page);

    /**
     * 添加联系
     * @param contact
     * @return
     */
    public Boolean addContact(Contact contact);

    /**
     * 修改联系
     * @param contact
     * @return
     */
    public Boolean updateContact(Contact contact);

    /**
     * 删除联系
     * @param id
     * @return
     */
    public Boolean deleteContactById(Integer id);
}
