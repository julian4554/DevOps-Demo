package com.webcore.solutions;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRequestRepository extends JpaRepository<ProjectRequest, Long> {
    List<ProjectRequest> findTop10ByOrderByCreatedAtDesc();
}