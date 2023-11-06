package pe.bancom.support.db.users;

import java.util.List;
import pe.bancom.support.domain.User;
import pe.bancom.support.domain.UserRequest;

/**
 * this class contains interface repository user
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

public interface UserRepository {
  List<User> get();
  String post(UserRequest request);
  String patch(UserRequest request);
  User getById(Integer id);
}
