package com.scau.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Created by zhonghua on 2016/8/8.
 */
public class PropertieHelper {

    private static Logger log=Logger.getLogger(PropertieHelper.class);

    private static Properties properties=null;

    public PropertieHelper() {
    }
//得到装有配置文件prop的信息的Properties
    public static Properties getPropInstance(String propName) throws IOException {
        properties=new Properties();
        String propPath = PropertieHelper.class.getResource("/").getPath() + propName;
//log.info在控制台输出
        log.info("propPath:"+propPath);
        //项目编译过后，resources目录不存在，配置文件直接在LandBigData/WEB-INF/classes下
        InputStream in = new BufferedInputStream(new FileInputStream(propPath));
        properties.load(in);
        return properties;
    }

}
