package com.allianz.example.util.dbutil;

import com.allianz.example.database.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface IBaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long > {
    Optional<T> findByUuid(UUID uuid);

}
