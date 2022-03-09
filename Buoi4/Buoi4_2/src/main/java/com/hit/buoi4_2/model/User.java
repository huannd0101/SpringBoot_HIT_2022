package com.hit.buoi4_2.model;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity //spring biet day la 1 thuc the (bảng trong sql)
@Table(name = "users") // đặt tên cho table trong sql
public class User {
    @Id //khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự động tăng id
    @Column(name = "id") // đặt tên cho cột - Nếu k thì sẽ lấy tên của thuộc tính làm tên cột
    private Long id;

    private String username;
    private String password;

    @Nationalized //viết tiếng việt (nvarchar)
    private String fullName; //full_name
    //time tạo
    //time update
    //status

    public User() {
    }

    public User(Long id, String username, String password, String fullName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
