package pe.bancom.support.db.posts;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.bancom.support.db.posts.mapper.PostMapper;
import pe.bancom.support.domain.Post;
import pe.bancom.support.domain.PostRequest;

/**
 * this class contains method repository post
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */


@Slf4j
@Repository
@AllArgsConstructor
public class PostRepositoryImpl implements PostRepository{

  private final JdbcTemplate template;
  private final PostMapper mapper;
  private final String POST_INSERT = "INSERT INTO posts (text, user_id, deleted, createdDate, createdBy, lastModifiedDate, lastModifiedBy) values (?, ?, ?, ?, ?, ?, ?)";
  private final String POST_UPDATE = "UPDATE posts SET text = ?, user_id = ?, deleted = ?, createdDate = ?, createdBy = ?, lastModifiedDate = ?, lastModifiedBy = ? WHERE id = ? and deleted = '0';";
  private final String POST_SELECT = "SELECT * FROM posts p INNER JOIN users u ON u.id = p.user_id  WHERE p.deleted = '0' and u.deleted = '0'";
  private final String POST_SELECT_BY_ID = "SELECT * FROM posts p INNER JOIN users u ON u.id = p.user_id  WHERE p.id = ? and p.deleted = '0'";

  @Override
  public List<Post> get() {
    return template.query(POST_SELECT, mapper);
  }

  @Override
  public String post(PostRequest request) {
    Integer response = template.update(POST_INSERT,
        request.getText(),
        request.getUserId(),
        request.getAudit().getDeleted(),
        request.getAudit().getCreatedDate(),
        request.getAudit().getCreatedBy(),
        request.getAudit().getLastModifiedDate(),
        request.getAudit().getLastModifiedBy());
    return String.valueOf(response);
  }

  @Override
  public String patch(PostRequest request) {
    Integer response = template.update(POST_UPDATE,
        request.getText(),
        request.getUserId(),
        request.getAudit().getDeleted(),
        request.getAudit().getCreatedDate(),
        request.getAudit().getCreatedBy(),
        request.getAudit().getLastModifiedDate(),
        request.getAudit().getLastModifiedBy(),
        request.getId());
    return String.valueOf(response);
  }

  @Override
  public Post getById(Integer id) {
    return template.query(POST_SELECT_BY_ID, mapper, id).get(0);
  }
}
