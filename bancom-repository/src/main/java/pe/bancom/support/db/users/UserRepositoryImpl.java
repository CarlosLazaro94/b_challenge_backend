package pe.bancom.support.db.users;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.bancom.support.db.users.mapper.UserMapper;
import pe.bancom.support.domain.User;
import pe.bancom.support.domain.UserRequest;

/**
 * this class contains method repository users
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Slf4j
@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate template;

  private final UserMapper mapper;
  private final String USER_INSERT = "INSERT INTO users (cellPhone, name, lastName, password, deleted, createdDate, createdBy, lastModifiedDate, lastModifiedBy) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private final String USER_UPDATE = "UPDATE users SET cellPhone = ?, name = ?, lastName = ?, password = ?, deleted = ?, createdDate = ?, createdBy = ?, lastModifiedDate = ?, lastModifiedBy = ? WHERE id = ? and deleted = '0';";
  private final String USER_SELECT = "SELECT * FROM users WHERE deleted = '0'";
  private final String USER_SELECT_BY_ID = "SELECT * FROM users WHERE id = ? and deleted = '0'";

  @Override
  public List<User> get() {
    return template.query(USER_SELECT, mapper);
  }

  @Override
  public String post(UserRequest request) {
    Integer response = template.update(USER_INSERT,
        request.getCellPhone(),
        request.getName(),
        request.getLastName(),
        request.getPassword(),
        request.getAudit().getDeleted(),
        request.getAudit().getCreatedDate(),
        request.getAudit().getCreatedBy(),
        request.getAudit().getLastModifiedDate(),
        request.getAudit().getLastModifiedBy());
    return String.valueOf(response);
  }

  @Override
  public String patch(UserRequest request) {
    Integer response = template.update(USER_UPDATE,
        request.getCellPhone(),
        request.getName(),
        request.getLastName(),
        request.getPassword(),
        request.getAudit().getDeleted(),
        request.getAudit().getCreatedDate(),
        request.getAudit().getCreatedBy(),
        request.getAudit().getLastModifiedDate(),
        request.getAudit().getLastModifiedBy(),
        request.getId());
    return String.valueOf(response);
  }

  @Override
  public User getById(Integer id) {
    return template.query(USER_SELECT_BY_ID, mapper, id).stream().findFirst().orElse(null);
  }
}
