package com.binus.skripsibe.service;

import com.binus.skripsibe.entity.Report;

import java.util.List;

public interface ReportService {
    Report createReport(Report report);
    List<Report> getAll();
    Report getReportById(String id);
}
