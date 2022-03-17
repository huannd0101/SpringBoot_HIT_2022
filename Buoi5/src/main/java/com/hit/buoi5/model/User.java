package com.hit.buoi5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity //spring biet day la 1 thuc the (bảng trong sql)
@Table(name = "users") // đặt tên cho table trong sql
@JsonIgnoreProperties({"username", "password"})
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

    @CreationTimestamp
    private Timestamp created;
    //time update

    @UpdateTimestamp
    private Timestamp updated;

    //status
    private Boolean status = Boolean.TRUE;

    //lien ket toi Address
    // mappedBy = "user": ten object bên bảng link tới
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore
    private List<Address> addresses;


    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public User() {
    }

    public User(String username, String password, String fullName) {
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}