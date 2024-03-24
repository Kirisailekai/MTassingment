package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.DataBootstrap;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private DataBootstrap dataBootstrap;

    @InjectMocks
    private UserService userService;

    @Test
    public void testFindAllUsers() {
        // Mocking repository behavior
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setFullName("User One");
        user1.setEmail("user1@example.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setFullName("User Two");
        user2.setEmail("user2@example.com");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Calling the service method that uses UserRepository
        List<User> users = userService.getAllUsers();

        // Verifying the result
        assertEquals(2, users.size());
        assertEquals("user1", users.get(0).getUsername());
        assertEquals("User One", users.get(0).getFullName());
        assertEquals("user1@example.com", users.get(0).getEmail());
        assertEquals("user2", users.get(1).getUsername());
        assertEquals("User Two", users.get(1).getFullName());
        assertEquals("user2@example.com", users.get(1).getEmail());
    }
}
