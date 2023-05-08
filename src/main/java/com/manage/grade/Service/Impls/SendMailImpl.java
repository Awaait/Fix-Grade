package com.manage.grade.Service.Impls;

import com.manage.grade.Entity.MailEntity;
import com.manage.grade.Service.SendMail;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;


/**
 * @className: SendMailImpl
 * @author: YCJ
 * @date: 2023/04/26 下午9:21
 **/
@Service
@Log4j
public class SendMailImpl implements SendMail {
    @Value("${spring.mail.username}")
    private String sendMailer;
    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(MailEntity mailEntity) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //邮件发件人
            helper.setFrom(sendMailer);
            //邮件收件人 1或多个
            helper.setTo(mailEntity.getSendTo().split(","));
            //邮件主题
            helper.setSubject(mailEntity.getSubject());
            //邮件内容
            helper.setText(mailEntity.getText(), true);
            //邮件发送时间
            helper.setSentDate(new Date());

            String filePath = mailEntity.getFilePath();
            if (StringUtils.hasText(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String  fileName = filePath.substring(filePath.lastIndexOf("\\")+1);
                helper.addAttachment(fileName, file);
            }
            javaMailSender.send(message);
            log.info(String.format("发送邮件成功:{%s}->{%s}", sendMailer, mailEntity.getSendTo()));
        } catch (MessagingException e) {
            log.error("发送邮件时发生异常！");
        }

    }
}
