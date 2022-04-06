package com.hit.buoi6.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(name = "name", nullable = false)
    private String name;
    private String slug;

    @Nationalized
    private String type;

    @Nationalized
    private String nameWithType;

    @Column(unique = true)
    private Long code;

    //link to table district
    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<District> districts;

}
