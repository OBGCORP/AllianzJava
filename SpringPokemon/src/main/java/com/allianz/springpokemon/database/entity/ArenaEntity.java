package com.allianz.springpokemon.database.entity;

import com.allianz.springpokemon.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@AttributeOverride(name = "uuid", column = @Column(name = "arena_uuid"))
@Data
public class ArenaEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String region;
}
