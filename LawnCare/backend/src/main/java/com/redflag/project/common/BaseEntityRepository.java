package com.redflag.project.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
