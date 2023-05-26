package com.binus.skripsibe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.File;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mst_report")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String caseName;
    private Date complaintDate;
    @ManyToOne
    @JoinColumn(name = "reporter_id")
    private UserDetail reporter;
    @OneToMany(mappedBy = "report")
    @JsonIgnoreProperties("report")
    private List<ReportVictim> victims;
    @OneToMany(mappedBy = "report")
    @JsonIgnoreProperties("report")
    private List<ReportSuspect> suspects;
    private String summaryComplaint;
    private String kindOfViolence;
    private String violenceForm;
    private String locationOfIncident;
    private String caseHistory;

    @ManyToOne
    @JoinColumn(name = "chancellor_id_id")
    private UserDetail chancellorId;
    private String caseNumber;
    private String caseStatus;
    private Date timeOfIncident;
    private File victimSupportDocument;

}
