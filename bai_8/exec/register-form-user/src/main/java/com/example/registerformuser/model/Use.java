package com.example.registerformuser.model;

import com.example.registerformuser.annotation.EmailAnnotation;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "use_information")
public class Use {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải từ 5-45 kí tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Tên chỉ được nhập a-z hoặc A-Z")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Độ dài phải từ 5-45 kí tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Tên chỉ được nhập a-z hoặc A-Z")
    private String lastName;

    @Min(value = 18, message = "Tuổi phải lớn hơn 18")
    @Max(value = 110,message = "Tuổi phải nhỏ hơn 110")
    private Integer age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ!")
    @EmailAnnotation
    private String email;

    public Use() {
    }

    public Use(Integer id, String firstName, String lastName, Integer age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
