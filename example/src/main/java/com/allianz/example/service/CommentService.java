package com.allianz.example.service;


import com.allianz.example.database.entity.CommentEntity;
import com.allianz.example.database.repository.CommentEntityRepository;
import com.allianz.example.mapper.CommentMapper;

import com.allianz.example.model.CommentDTO;
import com.allianz.example.model.requestDTO.CommentRequestDTO;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service

public class CommentService extends BaseService<CommentEntity, CommentDTO,
        CommentRequestDTO, CommentMapper, CommentEntityRepository> {
    @Autowired
    private CommentEntityRepository commentEntityRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public CommentMapper getMapper() {
        return commentMapper;
    }

    @Override
    public CommentEntityRepository getRepository() {
        return commentEntityRepository;
    }
}
