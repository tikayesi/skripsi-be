package com.binus.skripsibe.repository;

import com.binus.skripsibe.entity.ReportSuspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspectReportRepository extends JpaRepository<ReportSuspect, String> {
}
