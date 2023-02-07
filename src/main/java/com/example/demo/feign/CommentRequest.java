package com.example.demo.feign;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
public class CommentRequest {
    @JsonProperty("text")
    private String text;
}

