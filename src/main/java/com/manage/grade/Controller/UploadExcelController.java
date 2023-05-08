package com.manage.grade.Controller;

import com.manage.grade.Entity.ResponseResult;
import com.manage.grade.Service.ExcelParserService;
import com.manage.grade.Service.Impls.UploadServiceImpl;
import com.manage.grade.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @className: UploadExcelController
 * @author: YCJ
 * @date: 2023/05/08 下午1:39
 **/
@RestController
//TODO EXCEL util AND UPLOAD INTERFACE

public class UploadExcelController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private ExcelParserService excelParserService;

    @PostMapping("/upload")
    @PreAuthorize("hasAnyAuthority('teacher')")
    public ResponseResult UploadExcel(@RequestParam("file") MultipartFile multipartFile) {
        uploadService.UploadExcel(multipartFile);

        return uploadService.UploadExcel(multipartFile);
    }
}
