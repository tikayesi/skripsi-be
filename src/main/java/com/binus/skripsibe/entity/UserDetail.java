package com.binus.skripsibe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "mst_user_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @Column(unique = true)
    private String nik;
    private String fullName;
    @Column(name = "birth_of_place")
    private String birthPlace;
    @Column(name = "birth_of_date")
    private Date birthDate;
    private String gender;
    private String address;
    private String province;
    private String city;
    private String districts;
    private String postalCode;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;
    private String email;
    private String phoneNumber;
    private String education;
    private String religion;
    private String otherInformation;



}
