package com.example.settingsmailbox.service;

import com.example.settingsmailbox.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    MailBox getMailBox();

    List<String> getListLanguages();

    List<Integer> getListPageSizes();

    void update(MailBox mailBox);
}
