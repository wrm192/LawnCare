package com.redflag.project.user;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.redflag.project.common.BaseEntityRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends BaseEntityRepository<User> {
    User findById();
}
