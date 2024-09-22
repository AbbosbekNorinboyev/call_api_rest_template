package uz.pdp.call_api_rest_template.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import uz.pdp.call_api_rest_template.dto.CommentDTO;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private Integer postId;

    public Comment(CommentDTO commentCreateDTO) {
        this.message = commentCreateDTO.getMessage();
        this.postId = commentCreateDTO.getPostId();
    }
}