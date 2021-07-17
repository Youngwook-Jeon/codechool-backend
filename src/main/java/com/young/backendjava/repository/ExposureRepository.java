package com.young.backendjava.repository;

import com.young.backendjava.domain.ExposureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ExposureRepository extends JpaRepository<ExposureEntity, Long> {
    ExposureEntity findById(long id);
}
