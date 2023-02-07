package com.example.demo.model;

import dto.userDto.PersonDTO;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_id_gen")
    @SequenceGenerator(name = "comments_id_gen", sequenceName = "comments_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "post_id")
    private Long postId;
    private LocalDateTime time;
    @Column(name = "edit_time")
    private LocalDateTime editTime;
    private Long authorId;
    private String text;
    private boolean isBlocked;
    private boolean isDelete;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "like2comment",
            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    )
    private Set<PersonDTO> people;
    private Long likeAmount;
    private boolean myLike;
    private Long commentsCount;
}

