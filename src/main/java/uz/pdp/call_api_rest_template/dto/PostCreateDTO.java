package uz.pdp.call_api_rest_template.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.call_api_rest_template.post.Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class PostCreateDTO implements Serializable {
    private String title;
    private String body;
}