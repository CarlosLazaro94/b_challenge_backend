package pe.bancom.support.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.bancom.support.commons.CommonsHeaders;
import pe.bancom.support.domain.ResponseMessage;
import pe.bancom.support.domain.UserRequest;
import pe.bancom.support.domain.UserResponse;
import pe.bancom.support.service.user.UserService;

/**
 * this class controller contains operations for user
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("${pe.bancom.api.path}/users")
public class UserController {

  private UserService service;

  @Operation(responses = {
      @ApiResponse(responseCode = "200", description = "The request has been successful",
          content = @Content(schema = @Schema(implementation = UserResponse.class))) },
      summary = "This method get users list", method = "GET")
  @GetMapping
  public ResponseEntity<UserResponse> getUser() {
    return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON)
        .body(service.getUsers());
  }

  @Operation(responses = {
      @ApiResponse(responseCode = "200", description = "The request has been successful",
          content = @Content(schema = @Schema(implementation = ResponseMessage.class))) },
      summary = "This method for create users", method = "POST")
  @PostMapping
  public ResponseEntity<ResponseMessage> createUser(@RequestHeader(name = "user-code") String userCode,
      @RequestHeader(name = "request-id") String requestId,
      @RequestHeader(name = "request-date") String requestDate,
      @RequestBody @Validated UserRequest request) {
    return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON)
        .body(service.createUser(request, buildHeader(userCode, requestId, requestDate)));
  }

  @Operation(responses = {
      @ApiResponse(responseCode = "200", description = "The request has been successful",
          content = @Content(schema = @Schema(implementation = ResponseMessage.class))) },
      summary = "This method for update users", method = "PATCH")
  @PatchMapping
  public ResponseEntity<ResponseMessage> updateUser(@RequestHeader(name = "user-code") String userCode,
      @RequestHeader(name = "request-id") String requestId,
      @RequestHeader(name = "request-date") String requestDate,
      @RequestBody @Validated UserRequest request) {
    return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON)
        .body(service.updateUser(request, buildHeader(userCode, requestId, requestDate)));
  }

  @Operation(responses = {
      @ApiResponse(responseCode = "200", description = "The request has been successful",
          content = @Content(schema = @Schema(implementation = ResponseMessage.class))) },
      summary = "This method for delete users", method = "DELETE")
  @DeleteMapping
  public ResponseEntity<ResponseMessage> deleteUser(@RequestHeader(name = "user-code") String userCode,
      @RequestHeader(name = "request-id") String requestId,
      @RequestHeader(name = "request-date") String requestDate, @RequestParam String userId) {
    return ResponseEntity.status(HttpStatus.OK.value()).contentType(MediaType.APPLICATION_JSON)
        .body(service.deleteUser(userId, buildHeader(userCode, requestId, requestDate)));
  }

  private CommonsHeaders buildHeader(String userCode, String requestId, String requestDate) {
    return CommonsHeaders.builder().userCode(userCode).requestDate(requestDate).requestId(requestId)
        .build();
  }
}
