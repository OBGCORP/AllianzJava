package com.allianz.example.util;


import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface IBaseRepository<Entity extends BaseEntity> extends JpaRepository<Entity,Long> {
    Optional<Entity> findByUuid(UUID uuid);
}
