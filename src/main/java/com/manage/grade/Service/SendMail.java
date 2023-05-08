package com.manage.grade.Service;

import com.manage.grade.Entity.MailEntity;

public interface SendMail {
    void sendSimpleMail(MailEntity mailRequest);
}
