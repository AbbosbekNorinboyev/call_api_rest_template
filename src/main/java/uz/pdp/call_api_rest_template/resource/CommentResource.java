package uz.pdp.call_api_rest_template.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uz.pdp.call_api_rest_template.dto.CommentCreateDTO;
import uz.pdp.call_api_rest_template.dto.CommentDTO;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {
    private final RestTemplate restTemplate;
    @Value("${comments.url.postComments}")
    private String postCommentsURL;
    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;

    public List<CommentDTO> getAllComments(@NonNull Integer postId) {
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId());
//        List comments = responseEntity.getBody();

//        List comments = restTemplate.getForObject(url, List.class, post.getId());

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Authorization", "Bearer Token ..........................");
//        httpHeaders.setBearerAuth("token");
//        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
//        HttpEntity<Object> httpEntity = new HttpEntity<>(new Object(), httpHeaders);

        try {
            ResponseEntity<List<CommentDTO>> responseEntity = restTemplate.exchange(
                    postCommentsURL,
                    HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<>() {
                    },
                    postId
            );
            return responseEntity.getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void saveAll(List<CommentCreateDTO> dtoList) {
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(dtoList);
        restTemplate.exchange(saveCommentsURL, HttpMethod.POST, httpEntity, Void.class);
    }
}
