package com.manage.grade.Service;

import com.manage.grade.Entity.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
    ResponseResult UploadExcel(MultipartFile multipartFile);
}
