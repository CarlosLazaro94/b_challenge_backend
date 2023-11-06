package pe.bancom.support.service.post;

import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.domain.PostRequest;
import pe.bancom.support.domain.PostResponse;
import pe.bancom.support.domain.ResponseMessage;

/**
 * this class contains interfaces crud services
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

public interface PostService {
  PostResponse getPost();
  ResponseMessage createPost(PostRequest request, CommonsHeaders header);
  ResponseMessage updatePost(PostRequest request, CommonsHeaders header);
  ResponseMessage deletePost(String postId, CommonsHeaders headers);
}
