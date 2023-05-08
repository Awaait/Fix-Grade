package com.manage.grade.Service.Impls;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Service.UploadService;
import com.manage.grade.Utils.UploadUtils;
import lombok.extern.log4j.Log4j;
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
    @Override
    public ResponseResult UploadExcel(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return new ResponseResult<>(201, "上传失败");
        }
        /**
         *  获取文件初始名
         *  获取文件后缀
         *  生成uuid
         */
        String fileName = multipartFile.getOriginalFilename();
        String prefix = fileName.substring(fileName.indexOf(".") + 1);
        fileName = UUID.randomUUID().toString() + "." + prefix;
        File fileDir = UploadUtils.getExcelDirFile();
        String absUrl = fileDir.getAbsolutePath();
        try {
            File file = new File(absUrl + File.separator + fileName);
            System.err.println(file.getAbsolutePath());
            multipartFile.transferTo(file);
            log.info(String.format("上传Excel 成功 --> {%s}", file));
            return new ResponseResult(200, "success");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseResult(201, "上传异常 " + e.getMessage());
        }


    }
}
