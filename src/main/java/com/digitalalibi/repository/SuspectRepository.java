package com.digitalalibi.repository;

import com.digitalalibi.entity.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspectRepository extends JpaRepository<Suspect,Long> {
}
