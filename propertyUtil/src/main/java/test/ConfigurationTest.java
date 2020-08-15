package test;

import configurationUtil.PropertyUtils;

import java.io.File;
import java.util.Properties;

public class ConfigurationTest {

    public static void main (String[] args){
        ConfigurationTest ct = new ConfigurationTest();
        Properties properties = PropertyUtils.getProperty("/Users/wangyulin/Desktop/project/jdbc/Jdbc/src/main/resources/mysql.properties");
        Properties pro = PropertyUtils.getProperty("/Users/wangyulin/Desktop/project/jdbc/Jdbc/src/main/resources/mye.properties");
        String mysqlUrl = properties.getProperty("mysql_url");
        String my = pro.getProperty("second");
        System.out.println(mysqlUrl + "    " + my);
        //Properties propertie = PropertyUtils.getAbsoluteConfig("./resources/mysql.properties");

    }
}
