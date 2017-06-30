package com.taotao.manage.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by qiuhl on 2017/6/30.
 */
public interface PictureService {
    Map uploadPicture(MultipartFile uploadFile);
}
