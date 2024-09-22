package uz.pdp.call_api_rest_template.post;

import org.springframework.lang.NonNull;
import uz.pdp.call_api_rest_template.dto.CommentCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO getPost(@NonNull Integer id);

    PostDTO createPost(@NonNull PostCreateDTO dto);

    void createComments(@NonNull List<CommentCreateDTO> dtoList);
}
