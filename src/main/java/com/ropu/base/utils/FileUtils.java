package com.ropu.base.utils;

import java.io.*;

/**
 * Created by jaseeka
 * date 2015/7/21
 * time 17:53
 */
public class FileUtils {

    /**
     * 保存文件
     * @param rootPath
     * @param fileName
     * @param inputStream
     */
    public static void saveFile(String rootPath, String fileName, InputStream inputStream){
        File fileRoot = new File(rootPath);
        if (!fileRoot.exists()){
            fileRoot.mkdir();
        }

        try {
            FileOutputStream fos = new FileOutputStream(rootPath + fileName);
//            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buf)) > 0){
                fos.write(buf, 0, len);
            }
            if (inputStream != null){
                inputStream.close();
            }
            if (fos != null){
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存文件
     * @param rootPath
     * @param fileName
     * @param file
     */
    public static void saveFile(String rootPath, String fileName, File file){
        File fileRoot = new File(rootPath);
        if (!fileRoot.exists()){
            fileRoot.mkdir();
        }

        try {
            FileOutputStream fos = new FileOutputStream(rootPath+fileName);
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) > 0){
                fos.write(buf, 0, len);
            }
            if (fis != null){
                fis.close();
            }
            if (fos != null){
                fos.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
