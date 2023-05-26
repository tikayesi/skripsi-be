package com.binus.skripsibe.repository;

import com.binus.skripsibe.entity.ReportVictim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimReportRepository extends JpaRepository<ReportVictim, String> {
}
