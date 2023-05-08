package com.manage.grade.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @className: MailEntity
 * @author: YCJ
 * @date: 2023/04/26 下午9:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailEntity {
    /**
     * 接收人
     */
    private String sendTo;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 附件路径
     */
    private String filePath;

}
