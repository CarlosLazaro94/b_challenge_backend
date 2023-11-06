package pe.bancom.support.db.posts.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.bancom.support.domain.Post;
import pe.bancom.support.domain.User;

/**
 * this class contains mapper row for the post
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */


@Component
public class PostMapper implements RowMapper<Post> {
  @Override
  public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Post.builder()
        .id(rs.getInt("id"))
        .user(User.builder()
            .id(rs.getInt("user_id"))
            .name(rs.getString("name"))
            .cellPhone(rs.getString("cellPhone"))
            .lastName(rs.getString("lastName"))
            .build())
        .text(rs.getString("text"))
        .createDate(rs.getString("createdDate"))
        .createBy(rs.getString("createdBy"))
        .lastModifiedDate(rs.getString("lastModifiedDate"))
        .lastModifiedBy(rs.getString("lastModifiedBy"))
        .build();
  }
}
