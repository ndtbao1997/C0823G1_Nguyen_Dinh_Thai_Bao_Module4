package com.example.book_borrowing_application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Getter
public class UserDto {
    @PositiveOrZero
    private Integer id;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Tên không đúng định dạng!!!")
    private String nameUser;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^0\\d{9}$" , message = "Số điện thoại phải có 10 chữ số và bắt đầu bằng số 0")
    private String phoneNumber;

    public UserDto(Integer id, String nameUser, String phoneNumber) {
        this.id = id;
        this.nameUser = nameUser;
        this.phoneNumber = phoneNumber;
    }

    public UserDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
