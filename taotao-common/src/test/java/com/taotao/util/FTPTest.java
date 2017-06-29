package com.taotao.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by qiuhl on 2017/6/29.
 */
public class FTPTest {
    @Test
    public void testFtpUpload() throws IOException {
        InputStream inputStream = new FileInputStream(new File("D:\\Users\\qiuhl\\Pictures\\DCIM3.jpg"));

        FTPClient client = new FTPClient();
        client.connect("45.78.30.155", 21);
        client.login("ftpuser","qiuhuilu");
        client.enterLocalPassiveMode();
        client.setFileType(FTP.BINARY_FILE_TYPE);
        client.changeWorkingDirectory("/home/ftpuser/www");
        client.storeFile("hello.jpg",inputStream);
        client.logout();
    }

    @Test
    public void testUpload() throws FileNotFoundException {
        FtpUtils ftpUtils = new FtpUtils();
        InputStream inputStream = new FileInputStream(new File("D:\\Users\\qiuhl\\Pictures\\DCIM3.jpg"));
        boolean result = ftpUtils.uploadFile("45.78.30.155", 21,"ftpuser","qiuhuilu","/home/ftpuser/www","/2015/06/29","hello.jpg",inputStream);
        System.out.println(result);
    }
}
