package com.summit.user_service.service;


import com.summit.user_service.dto.UserDTO;

import java.util.List;
public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO updateVerificationStatus(String email, boolean isVerified);
    void deleteUser(Long id);
}