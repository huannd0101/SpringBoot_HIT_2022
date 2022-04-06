package com.hit.buoi6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class District {
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

    @Nationalized
    private String path;

    @Nationalized
    private String pathWithType;

    @Column(unique = true)
    private Long code;

    @Column(unique = true)
    private Long parentCode;

    //link to table province
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "province_id")
    private Province province;

}
