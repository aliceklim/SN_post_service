package com.example.demo.dto.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Комментарий")
public class CommentDTO {
    private Long id;
    private Long postId;
    private ZonedDateTime time;
    private ZonedDateTime editTime;
    private Long authorId;
    private String text;
    private boolean isBlocked;
    private boolean isDelete;
    private Long likeAmount;
    private boolean myLike;
    private String imagepath;
}

