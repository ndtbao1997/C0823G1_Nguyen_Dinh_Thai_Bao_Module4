package com.example.settingsmailbox.repository;

import com.example.settingsmailbox.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    MailBox getMailBox();

    List<String> getListLanguages();

    List<Integer> getListPageSizes();

    void update(MailBox mailBox);
}
