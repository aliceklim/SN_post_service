package com.example.demo.services;

import com.example.demo.feign.CommentRequest;
import com.example.demo.feign.PersonService;
import com.example.demo.mappers.CommentMapper;
import com.example.demo.model.Comment;
import com.example.demo.repositories.CommentRepository;
import dto.userDto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PersonService personService;
    private final CommentMapper commentMapper;

    public CommentDTO addComment(Long postId, CommentRequest commentRequest, String userEmail){
        PersonDTO user = personService.getPersonDTOByEmail(userEmail);
        LocalDateTime time = LocalDateTime.now();
        Comment comment = Comment.builder()
                        .authorId(user.getId())
                        .commentsCount(0L)
                        .isBlocked(false)
                        .isDelete(false)
                        .likeAmount(0L)
                        .myLike(false)
                        .text(commentRequest.getText())
                        .postId(postId)
                        .time(time)
                        .build();

        commentRepository.save(comment);
        return commentMapper.toDTO(comment);
    }

    public void editComment(Long postId, Long commentId, CommentRequest commentRequest, Long id){
        Optional<Comment> comment = Optional.ofNullable(commentRepository.findByIdAndPostId(commentId, postId));
        commentRepository.save(comment.get());
    }

    public void deleteComment(Long postId, Long commentId){
        Optional<Comment> comment = Optional.ofNullable(commentRepository.findByIdAndPostId(commentId, postId));
        commentRepository.delete(comment.get());
    }

    public List<CommentDTO> getAllComments(Long postId){
        return commentRepository
                .findAllByPostId(postId)
                .stream()
                .map(comment -> commentMapper.toDTO(comment))
                .collect(Collectors.toList());
    }

}

