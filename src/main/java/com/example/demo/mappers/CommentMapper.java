package com.example.demo.mappers;

import com.example.demo.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toDTO(Comment comment);
    Comment toComment (CommentDTO commentDTO);

}
