package com.example.settingsmailbox.service;

import com.example.settingsmailbox.model.MailBox;
import com.example.settingsmailbox.repository.IMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MailBoxService implements IMailBoxService{
    @Autowired
    private IMailBoxRepository iMailBoxRepository;
    @Override
    public MailBox getMailBox() {
        return iMailBoxRepository.getMailBox();
    }

    @Override
    public List<String> getListLanguages() {
        return iMailBoxRepository.getListLanguages();
    }

    @Override
    public List<Integer> getListPageSizes() {
        return iMailBoxRepository.getListPageSizes();
    }

    @Override
    public void update(MailBox mailBox) {
        iMailBoxRepository.update(mailBox);
    }
}
