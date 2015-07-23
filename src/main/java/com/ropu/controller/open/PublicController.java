package com.ropu.controller.open;

import com.ropu.base.utils.FileUtils;
import com.ropu.base.utils.JsonUtils;
import com.ropu.common.ResultCode;
import com.ropu.common.ResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jaseeka
 * date 2015/7/21
 * time 20:21
 */
@Controller
@RequestMapping("/open")
public class PublicController {

    /**
     * 文件上传
     * @param type
     * @param file
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8")
    public String uploadFile(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "file")MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // 获取后缀
        String suffix = file.getOriginalFilename().substring
                (file.getOriginalFilename().lastIndexOf("."));

        String root = request.getSession().getServletContext().getRealPath("");

        String path = File.separator + "upload" + File.separator + dateFormat.format(now) + File.separator;
        String fileName = String.valueOf(now.getTime()) + suffix;

        String fileUrl = path + fileName;

        try {
            FileUtils.saveFile(root + path, fileName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
            return JsonUtils.Object2Json(resultEntity);
        }

        resultEntity.setCode(ResultCode.SUCCESS);
        resultEntity.setMsg(ResultCode.MSUCCESS);
        resultEntity.getData().put("url",fileUrl);

        return JsonUtils.Object2Json(resultEntity);
    }
}
