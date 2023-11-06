package pe.bancom.support.db.posts;

import java.util.List;
import pe.bancom.support.domain.Post;
import pe.bancom.support.domain.PostRequest;

/**
 * this class contains interface repository post
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */


public interface PostRepository {
  List<Post> get();
  String post(PostRequest request);
  String patch(PostRequest request);
  Post getById(Integer id);
}
