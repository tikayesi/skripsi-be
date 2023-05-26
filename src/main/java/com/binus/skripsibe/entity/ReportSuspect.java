package com.binus.skripsibe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "trx_report_suspect")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportSuspect {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "userDetail_id")
    private UserDetail userDetail;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
    private String victimRelationship;
}
