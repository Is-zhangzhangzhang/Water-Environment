package com.scau.service;

import javax.servlet.http.HttpServletRequest;

import com.scau.pojo.File;

import java.util.List;

/**
 * Created by zhonghua on 2016/7/20.
 */
public interface IFileService {
    public List<String> getFileList(String downLoadPath);
    public void uploadFile(String localName, String storePath);
    public void downloadFile(String storePath);
}
