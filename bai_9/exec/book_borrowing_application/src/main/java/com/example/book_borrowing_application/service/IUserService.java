package com.example.book_borrowing_application.service;

import com.example.book_borrowing_application.dto.UserDto;
import com.example.book_borrowing_application.model.User;

public interface IUserService extends IGenerateService<User>{
    UserDto setUser(UserDto user);
}
