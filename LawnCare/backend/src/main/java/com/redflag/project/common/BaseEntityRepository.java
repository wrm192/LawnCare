package com.redflag.project.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
}
