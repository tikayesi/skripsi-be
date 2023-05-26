package com.binus.skripsibe.service.impl;

import com.binus.skripsibe.entity.Report;
import com.binus.skripsibe.entity.ReportSuspect;
import com.binus.skripsibe.entity.ReportVictim;
import com.binus.skripsibe.repository.ReportRepository;
import com.binus.skripsibe.repository.SuspectReportRepository;
import com.binus.skripsibe.repository.VictimReportRepository;
import com.binus.skripsibe.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    ReportRepository reportRepository;

    VictimReportRepository victimReportRepository;

    SuspectReportRepository suspectReportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, VictimReportRepository victimReportRepository, SuspectReportRepository suspectReportRepository) {
        this.reportRepository = reportRepository;
        this.victimReportRepository = victimReportRepository;
        this.suspectReportRepository = suspectReportRepository;
    }

    @Override
    @Transactional
    public Report createReport(Report report) {
        report.setCaseStatus("On Hold");
        report.setComplaintDate(new Date());
        Report report1 = reportRepository.save(report);
        for (ReportVictim v : report.getVictims()) {
            v.setReport(report1);
            victimReportRepository.save(v);
        }
        for (ReportSuspect s : report.getSuspects()) {
            s.setReport(report1);
            suspectReportRepository.save(s);
        }
        return report1;
    }

    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Report getReportById(String id) {
        return reportRepository.findById(id).get();
    }

}
