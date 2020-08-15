package configurationUtil;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PropertyUtils {
    private static Properties property;
    private static String path;
    private static Map<Object,Object> propertiesMap = new HashMap<Object, Object>();
    private static Logger logger = Logger.getLogger(Properties.class);
    /**
     * 初始化配置文件对象
     * @param absolutePath
     * @return
     */
    private static void setAbsoluteConfig(String absolutePath){

        Properties properties = new Properties();
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(absolutePath));
            properties.load(bufferedReader);
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("配置文件绝对地址写错");
            //log4j输出绝对文件名写错了
        }
        finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    //log4j关闭流时发生错误
                    logger.error("关闭流时发生错误");
                }
            }
        }
        if(properties != null) {
            propertiesMap.put(absolutePath, properties);
        }
    }

    /**
     * 获得配置文件键值对象
     * @param absolutePath
     * @return
     */
    public static Properties getProperty(String absolutePath){

        if(!propertiesMap.containsKey(absolutePath)){
            setAbsoluteConfig(absolutePath);
        }
        return (Properties) propertiesMap.get(absolutePath);
    }

}
