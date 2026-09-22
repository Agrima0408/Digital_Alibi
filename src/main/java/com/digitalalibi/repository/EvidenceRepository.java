package com.digitalalibi.repository;

import com.digitalalibi.entity.Case;
import com.digitalalibi.entity.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence,Long> {

}
