package com.example.settingsmailbox.repository;

import com.example.settingsmailbox.model.MailBox;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static MailBox mailBox;
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> pageSizes = new ArrayList<>();
    static {
        mailBox = new MailBox("English",15,"Enable spams filter","aaa");
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSizes.add(5);
        pageSizes.add(10);
        pageSizes.add(15);
        pageSizes.add(25);
        pageSizes.add(50);
        pageSizes.add(100);
    }

    @Override
    public MailBox getMailBox() {
        return mailBox;
    }

    @Override
    public List<String> getListLanguages() {
        return languages;
    }

    @Override
    public List<Integer> getListPageSizes() {
        return pageSizes;
    }

    @Override
    public void update(MailBox mailBoxNew) {
        mailBox.setLanguages(mailBoxNew.getLanguages());
        mailBox.setPageSize(mailBoxNew.getPageSize());
        mailBox.setSpamsFilter(mailBoxNew.getSpamsFilter());
        mailBox.setSignature(mailBoxNew.getSignature());
    }
}
