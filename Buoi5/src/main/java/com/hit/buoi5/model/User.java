package com.hit.buoi5.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity //spring biet day la 1 thuc the (bảng trong sql)
@Table(name = "users") // đặt tên cho table trong sql
@JsonIgnoreProperties({"password"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
//    @JsonIgnore
    @JsonManagedReference
    private List<Address> addresses;

    public User(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

}