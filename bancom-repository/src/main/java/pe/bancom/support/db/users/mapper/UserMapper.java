package pe.bancom.support.db.users.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import pe.bancom.support.domain.User;

/**
 * this class contains mapper row for the user
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Component
public class UserMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    return User.builder()
        .id(rs.getInt("id"))
        .name(rs.getString("name"))
        .cellPhone(rs.getString("cellPhone"))
        .lastName(rs.getString("lastName"))
        .password(rs.getString("password"))
        .createdDate(rs.getString("createdDate"))
        .createdBy(rs.getString("createdBy"))
        .lastModifiedDate(rs.getString("lastModifiedDate"))
        .lastModifiedBy(rs.getString("lastModifiedBy"))
        .build();
  }
}
