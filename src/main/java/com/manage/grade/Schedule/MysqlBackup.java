package com.manage.grade.Schedule;

import com.manage.grade.Entity.MailEntity;
import com.manage.grade.Service.Impls.SendMailImpl;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * @className: MysqlBackup
 * @author: YCJ
 * @date: 2023/04/29 下午12:58
 **/
@Component
@Log4j
@EnableScheduling
@Configuration
public class MysqlBackup {
    @Autowired
    private SendMailImpl sendMail;
    /**
     * SQL INFO
     */
    @Value("${spring.datasource.druid.url}")
    private String dbUrl;

    @Value("${spring.datasource.druid.username}")
    private String dbUserName;

    @Value("${spring.datasource.druid.password}")
    private String dbPassWord;
    @Value("${mail.sendTo}")
    private String MailSendTo;


    /**
     * 每周6 12点 【  0 0 12 ? * WED 】
     * 测试 20 秒一次【  0/20 * * * * ? 】
     */
    @Scheduled(cron = "0 0 12 ? * WED")
    private void SqlBackUpAndSendMail() {
        String resourcePath = "E:\\code\\JavaExam\\Grade";
        log.info("======执行定时器:定时备份数据库=======");
        String backUpPath = resourcePath + "/sql";
        File backUpFile = new File(backUpPath);
        if (!backUpFile.exists()) {
            backUpFile.mkdirs();
        }
        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(date));
        File dataFile = new File(backUpPath + "/" + formatter.format(date) + "-" + "Grade" + ".sql");
        //拼接cmd命令
        StringBuilder sb = new StringBuilder();
        sb.append("mysqldump");
        sb.append(" -u").append(dbUserName);
        sb.append(" -p").append(dbPassWord);
        sb.append(" " + "grade" + " > ");
        sb.append(dataFile);
        log.info("======数据库备份cmd命令为：" + sb.toString() + "=======");
        try {
            Process exec = Runtime.getRuntime().exec("cmd /c" + sb);
            if (exec.waitFor() == 0) {
                log.info("======数据库备份成功，路径为：" + dataFile);
                String subject = String.valueOf(java.sql.Date.valueOf(LocalDate.now()));
                String text = subject + "  " + "备份数据";
                MailEntity mail = new MailEntity(MailSendTo, subject, text, dataFile.toString());
                sendMail.sendSimpleMail(mail);
            }
        } catch (Exception e) {
            log.info("======数据库备份失败，异常为：" + e.getMessage());
        }

    }


    /**
     * 判断文件是否存在，不存在创建
     */
    private static void existsFile(File file) {
        // 判断文件路径是否存在,不存在新建
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
