package uz.pdp.call_api_rest_template.post;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.call_api_rest_template.dto.CommentCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostDTO;
import uz.pdp.call_api_rest_template.resource.CommentResource;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentResource commentResource;

    @Override
    public PostDTO getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found: " + id));
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .comments(commentResource.getAllComments(post.getId()))
                .build();
    }


    @Override
    public PostDTO createPost(@NonNull PostCreateDTO dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
        postRepository.save(post);
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

    @Override
    public void createComments(@NonNull List<CommentCreateDTO> commentCreateDTOS) {
        commentResource.saveAll(commentCreateDTOS);
    }
}
