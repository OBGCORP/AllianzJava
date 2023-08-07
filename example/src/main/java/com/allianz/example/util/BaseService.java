package com.allianz.example.util;

import com.allianz.example.util.dbutil.BaseEntity;
import com.allianz.example.util.dbutil.IBaseEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BaseService <T extends BaseEntity, DTO extends BaseDTO, RDTO extends BaseDTO> {

    @Autowired
    IBaseEntityRepository<T> iBaseEntityRepository;

    @Autowired
    IBaseMapper<DTO, T, RDTO> iBaseMapper;


    public DTO getDTOByUuid(UUID uuid){
        Optional<T> entity = iBaseEntityRepository.findByUuid(uuid);

        return entity.map(t -> iBaseMapper.entityToDTO(t)).orElse(null);

    }

    @Transactional
    public boolean deleteEntityByUuid(UUID uuid){
        DTO entityDTO = getDTOByUuid(uuid);
        T entity = iBaseMapper.dtoToEntity(entityDTO);

        if(entity != null){
            iBaseEntityRepository.deleteById(entity.getId());

            return true;
        } else {
            return false;
        }
    }
}


