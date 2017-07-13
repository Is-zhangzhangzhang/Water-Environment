package com.scau.service.impl;

import com.scau.service.IFileService;
import com.scau.util.SSHHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class FileServiceImpl implements IFileService {

    private List<String> fileToList(String path) {
        File src = new File(path);
        if (src.exists() && src.isFile()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(src));
                List<String> dest = new ArrayList<String>();
                String line = null;
                while ((line = br.readLine()) != null) {
                    dest.add(line.trim());
                }
                return dest;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else
            return null;
    }

    public List<String> getFileList(String downLoadPath) {
        //将结果文件从HDFS中保存到Hadoop集群本地文件系统
        getFilesFromHDFS();
        SSHHelper.executeOnly("ls  ~/Documents/Hadoop/tmp/result>> ~/Document/Hadoop/tmp/result/file_list.txt");
        SSHHelper.downloadFileFromRemote(new String[]{"~/Document/Hadoop/tmp/result/file_list.txt"}, downLoadPath);

        return fileToList(downLoadPath + "/file_list.txt");
    }

    public void uploadFile(String localName, String storePath) {
        String localDir = storePath + localName;

        String[] localDirs = new String[]{localDir};

        //首先将数据从web服务器上传到hadoop服务器本地
        SSHHelper.uploadFilesToRemote(localDirs, "~/Documents/Hadoop/tmp/data/");

        //再将文件从hadoop服务器本地传进hdfs中
        SSHHelper.executeOnly("hadoop fs -put ~/Documents/Hadoop/tmp/data/* /user/slave/testdata/");

       /* //最后删除Hadoop服务器本地文件目录下的文件
        SSHHelper.executeOnly("rm ~/Documents/Hadoop/tmp/data/"+localName);*/
    }

    private void getFilesFromHDFS() {
        //先将文件从hdfs中下载到hadoop本地服务器中的临时文件
        SSHHelper.executeOnly("hadoop fs -get /user/slave/output/* ~/Documents/Hadoop/tmp/result/");

        //清空HDFS的output文件夹
        //SSHHelper.executeOnly("hadoop fs -rmr /user/slave/output");
    }

    /**
     * 将结果文件从Hadoop集群下载到web服务器
     * ！！！现存问题：HDFS中，结果文件被封装到文件夹中，加大了下载难度和管理难度
     *
     * @param storePath
     */
    public void downloadFile(String storePath) {
        String downloadDir = storePath + "download";

        //确保下载路径存在，不存在则创建
        File downloadDirFile = new File(downloadDir);
        if (!downloadDirFile.exists())
            downloadDirFile.mkdir();

        //获取结果文件列表
        List<String> fileList = getFileList(downloadDir);

        //再从临时文件传到web服务器中
        SSHHelper.downloadFileFromRemote((String[]) fileList.toArray(), downloadDir);

        //清空Hadoop集群本地临时文件
        SSHHelper.executeOnly("rm ~/Document/Hadoop/tmp/result");
    }
}
