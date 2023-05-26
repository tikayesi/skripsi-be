package com.binus.skripsibe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "trx_report_victim")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportVictim {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
    private String reporterRelationship;
    private String suspectRelationship;
}
