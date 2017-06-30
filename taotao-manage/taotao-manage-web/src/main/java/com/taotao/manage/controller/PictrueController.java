package com.taotao.manage.controller;

import com.taotao.manage.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 图片Controller
 * Created by qiuhl on 2017/6/30.
 */
@Controller
@RequestMapping("/pic")
public class PictrueController {

    @Autowired
    private PictureService pictureService;

    /**
     * 图片上传
     * @param uploadFile 多文件对象  MultipartFile
     * @return
     * 成功
     * {
     *     "error":0,
     *     "url":"http://www.example.com/path/to/file.ext"
     * }
     * 失败
     * {
     *     "error":1,
     *     "message":"错误信息"
     * }
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map uploadPicture(MultipartFile uploadFile){
        Map result = pictureService.uploadPicture(uploadFile);
        return result;
    }
}
