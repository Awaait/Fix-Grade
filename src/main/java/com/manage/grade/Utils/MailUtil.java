package com.manage.grade.Utils;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.Path;
import java.util.Date;

/**
 * @className: MailUtil
 * @author: YCJ
 * @date: 2023/04/26 下午9:04
 **/

public class MailUtil {
    @Resource
    private JavaMailSenderImpl mailSender;

    /**
     *
     * @param MailSendToAddress 收件人地址
     * @param FileName 发送附件名称
     * @param MailText 发送邮件内容
     * @param FileAddress 收件人地址
     * @param MailHead 邮件标题
     * @throws MessagingException
     */
    public void sendAttachmentMail(String MailSendToAddress, String FileName,
                                   String MailText, String FileAddress, String MailHead) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // true表示构建一个可以带附件的邮件对象
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject(MailHead);
        helper.setFrom("susu2580k@163.com");
        helper.setTo(MailSendToAddress);
        helper.setSentDate(new Date());
        helper.setText(MailText);
        // 第一个参数是自定义的名称，后缀需要加上，第二个参数是文件的位置
        helper.addAttachment(FileName, new File(FileAddress));
        mailSender.send(mimeMessage);
    }
}
