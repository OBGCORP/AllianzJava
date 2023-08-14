package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<Entity extends BaseEntity, DTO extends BaseDTO,
        RequestDTO extends BaseDTO, Mapper extends BaseMapper<DTO, Entity, RequestDTO>,
        Repository extends IBaseRepository<Entity>> {

    public abstract Mapper getMapper();

    public abstract Repository getRepository();

    public DTO save(RequestDTO dto) {
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public DTO update(UUID uuid, RequestDTO dto) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);

        if (entity != null) {
            entity = getMapper().requestDTOToExistEntity(dto, entity);
            getRepository().save(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public boolean deleteByUuid(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        if (optionalEntity.isPresent()) {
            getRepository().deleteById(optionalEntity.get().getId());
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public DTO getByUuid(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        if (optionalEntity.isPresent()) {
            return getMapper().entityToDTO(optionalEntity.get());
        } else {
            return null;
        }
    }

    public List<DTO> getAll() {
        return getMapper().entityListToDTOList(getRepository().findAll());
    }

}


