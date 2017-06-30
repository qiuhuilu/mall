package com.taotao.manage.service.impl;

import com.taotao.manage.service.PictureService;
import com.taotao.util.FtpUtils;
import com.taotao.util.IDUtils;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 上传图片Service
 * Created by qiuhl on 2017/6/30.
 */
@Service
public class PictureServiceImpl implements PictureService{

    //通过Spring注入配置文件
    @Value("${FTP_HOST}")
    private String FTP_HOST;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USER}")
    private String FTP_USER;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_SERVER}")
    private String IMAGE_SERVER;
    @Value("${IMAGE_BASE_PATH}")
    private String IMAGE_BASE_PATH;


    /**
     * KindEditor控件上传图片
     * @param uploadFile MultipartFile多文件对象
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
    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resultMap = new HashMap();
        try {
            //获取上传图片的扩展名
            String originName = uploadFile.getOriginalFilename();
            //生成新的文件名，采用毫秒时间+随机数
            String newName = IDUtils.genItemId() + originName.substring(originName.indexOf("."));
            //FilePath 根据日期生成YYYY/MM/DD格式的文件路径
            DateTime dateTime = new DateTime();
            String filePath = dateTime.toString("YYYY/MM/dd");

            //上传图片到服务器
            boolean result = FtpUtils.uploadFile(FTP_HOST, FTP_PORT, FTP_USER, FTP_PASSWORD, FTP_BASE_PATH, filePath, newName, uploadFile.getInputStream());
            if(result){
                //图片地址
                String url = IMAGE_SERVER + IMAGE_BASE_PATH + filePath + "/" + newName;
                resultMap.put("error", 0);
                resultMap.put("url", url);
            }else {
                resultMap.put("error", 1);
                resultMap.put("error", "上传图片失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
            resultMap.put("error", 1);
            resultMap.put("message", "上传图片异常");
            return resultMap;
        }

        return resultMap;
    }
}
