package cn.pinkhorizon.commons.base.util;

/**
 * @author ybf
 * @description 文件工具类
 */
public class FileUtils {
    /**
     * 通过文件的资源路径获取文件的绝对路径，例如：mapper/TstMapper.xml
     */
    public static String getAbsolutePath(String fileClassPath) {
        return FileUtils.class.getClassLoader().getResource(fileClassPath).getPath();
    }
}