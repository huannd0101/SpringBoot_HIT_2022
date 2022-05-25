package com.hit.buoi9.models;

import com.hit.buoi9.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;

    private String password;

    @Nationalized //tiếng việt
    private String fullName;

    @Column(name = "avatar")
    private String avatar;
}
