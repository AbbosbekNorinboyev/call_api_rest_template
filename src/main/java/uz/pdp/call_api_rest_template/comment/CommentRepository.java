package uz.pdp.call_api_rest_template.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.postId = ?1")
    List<Comment> findAllByPostId(Integer postId);
}