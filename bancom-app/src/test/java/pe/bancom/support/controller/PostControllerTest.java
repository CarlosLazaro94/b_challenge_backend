package pe.bancom.support.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import pe.bancom.support.domain.PostRequest;
import pe.bancom.support.domain.PostResponse;
import pe.bancom.support.domain.ResponseMessage;
import pe.bancom.support.service.post.PostService;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @InjectMocks
  private PostController postController;

  @Mock
  private PostService service;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Return posts list")
  void returnUserList() {
    when(service.getPost()).thenReturn(PostResponse.builder().build());
    ResponseEntity<PostResponse> response = postController.getPost();
    verify(service, times(1)).getPost();
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }
  @Test
  void testCreatePost() {
    when(service.createPost(any(), any())).thenReturn(ResponseMessage.builder().build());
    ResponseEntity<ResponseMessage> response = postController.createPost("userCode", "requestId", "requestDate",
        PostRequest.builder().build());
    verify(service, times(1)).createPost(any(), any());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void testUpdatePost() {
    when(service.updatePost(any(), any())).thenReturn(ResponseMessage.builder().build());
    ResponseEntity<ResponseMessage> response = postController.updatePost("userCode", "requestId", "requestDate", PostRequest.builder().build());
    verify(service, times(1)).updatePost(any(), any());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void testDeletePost() {
    when(service.deletePost(any(), any())).thenReturn(ResponseMessage.builder().build());
    ResponseEntity<ResponseMessage> response = postController.deletePost("userCode", "requestId", "requestDate", "postId");
    verify(service, times(1)).deletePost(any(), any());
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

}