package com.binus.skripsibe.controller;

import com.binus.skripsibe.entity.Report;
import com.binus.skripsibe.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/reports")
    public Report createReport(@RequestBody Report report){
      return reportService.createReport(report);
    }

    @GetMapping("/reports")
    public List<Report> getAllReport(){
       return reportService.getAll();
    }

    @GetMapping("/reports/{id}")
    public Report getReportById(@PathVariable String id){
        return reportService.getReportById(id);
    }
}
