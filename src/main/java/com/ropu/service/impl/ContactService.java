package com.ropu.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ropu.common.Page;
import com.ropu.dao.ContactDao;
import com.ropu.entity.Contact;
import com.ropu.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jaseeka
 * date 2015/7/20
 * time 17:51
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    /**
     * 获取联系列表
     * @param contact
     * @param page
     * @return
     */
    @Override
    public PageList<Contact> getContactList(Contact contact, Page page){
        if (contact == null){
            contact = new Contact();
        }
        if (page == null){
            page = new Page();
        }
        PageList<Contact> contactPageList = contactDao.selectAndLike(contact, page.gainPageBounds());

        return contactPageList;
    }

    /**
     * 添加联系
     * @param contact
     * @return
     */
    public Boolean addContact(Contact contact){
        if (contact == null){
            return false;
        }
        Integer result = contactDao.insert(contact);

        return result > 0 ? true : false;
    }

    /**
     * 修改联系
     * @param contact
     * @return
     */
    public Boolean updateContact(Contact contact){
        if (contact == null || contact.getId() == null || contact.getId() <= 0){
            return false;
        }
        Integer result = contactDao.update(contact);

        return result > 0 ? true : false;
    }

    /**
     * 删除联系
     * @param id
     * @return
     */
    public Boolean deleteContactById(Integer id){
        if (id == null || id <= 0){
            return false;
        }
        Contact contact = new Contact();
        contact.setId(id);
        Integer result = contactDao.deleteById(contact);

        return result > 0 ? true : false;
    }
}
