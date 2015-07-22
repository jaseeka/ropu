package com.ropu.controller.admin;

import com.ropu.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jaseeka
 * date 2015/7/22
 * time 21:24
 */
@Controller
@RequestMapping("/admin")
public class ContactController extends BaseWebController {

    @Autowired
    private IContactService contactService;

}
