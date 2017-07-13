package com.unit;

import com.dlut.service.IFileService;
import com.dlut.service.impl.FileServiceImpl;
import com.dlut.util.SSHHelper;
import org.junit.Test;

/**
 * Created by Administrator on 2016/8/11.
 */
public class SSHTest {
    @Test
    public void testConnection() {
        SSHHelper.executeOnly("ls");
    }

    @Test
    public void testExecute() {
        SSHHelper.executeCmd("start-all.sh");
        String line = null;
        while ((line = SSHHelper.readStdout()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void testUpload() {
        IFileService fileService = new FileServiceImpl();
        fileService.uploadFile("ssh.properties", "E:\\土地大数据\\LandBigData\\src\\main\\resources\\");
    }

    @Test
    public void testDownload() {
        IFileService fileService = new FileServiceImpl();
        fileService.downloadFile("E:\\土地大数据\\test");
    }

    @Test
    public void testClose() {
        SSHHelper.close();
    }
}
