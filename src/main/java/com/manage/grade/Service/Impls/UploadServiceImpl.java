package com.manage.grade.Service.Impls;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Service.ExcelParserService;
import com.manage.grade.Service.UploadService;
import com.manage.grade.Utils.UploadUtils;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @className: UploadServiceImpl
 * @author: YCJ
 * @date: 2023/05/08 下午1:45
 **/

//TODO 保存成功后 依旧执行 上传异常部分
@Service
@Log4j
public class UploadServiceImpl implements UploadService {
    @Autowired
    private ExcelParserService excelParserService;

    @Async
    @Override
    public ResponseResult UploadExcel(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return new ResponseResult(201, "请选择文件");
        }
        String filename = multipartFile.getOriginalFilename();
        String prefix = filename.substring(filename.lastIndexOf(".") + 1);
        filename = UUID.randomUUID().toString().replace("-", "") + "." + prefix;

        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getExcelDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        String url = fileDir.getAbsolutePath();
        try {
            // 构建真实的文件路径
            File newFile = new File(url + File.separator + filename);
            log.info(String.format("上传Excel成功-->{%s}", newFile.toString()));
            // 上传图片到 -》 “绝对路径”
//            multipartFile.transferTo(newFile);
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), newFile);
            return new ResponseResult(200, "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseResult(201, "上传异常");
        }
    }
}
