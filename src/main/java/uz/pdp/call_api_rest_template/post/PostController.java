package uz.pdp.call_api_rest_template.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.call_api_rest_template.dto.CommentCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostCreateDTO;
import uz.pdp.call_api_rest_template.dto.PostDTO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostCreateDTO dto) {
        return ResponseEntity.ok(postService.createPost(dto));
    }

    @PostMapping("/comments")
    public ResponseEntity<Void> createComments(@RequestBody List<CommentCreateDTO> dtos) {
        postService.createComments(dtos);
        return ResponseEntity.noContent().build();
    }
}

/*
{
  "name": "Non",
  "description": "Yeyish uchun",
  "price": 3000,
  "date": "2024-09-05T12:50:11.871Z"
}
 */
