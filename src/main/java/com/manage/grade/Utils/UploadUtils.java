package com.manage.grade.Utils;

import java.io.File;

public class UploadUtils {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）

    public static File getExcelDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("E:\\FIx\\grade\\Excel");

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}
