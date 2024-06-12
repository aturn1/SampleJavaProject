package com.myapp.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Test case for getUserById method
        UserService userService = new UserService();
        User user = userService.getUserById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testGetUserByEmail() {
        // Test case for getUserByEmail method
        UserService userService = new UserService();
        User user = userService.getUserByEmail("john.doe@example.com");
        assertNotNull(user);
        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    public void testAddUser() {
        // Test case for addUser method
        UserService userService = new UserService();
        User user = new User(2, "Jane Smith", "jane.smith@example.com");
        userService.addUser(user);
        assertEquals(2, userService.getAllUsers().size());
        assertEquals(user, userService.getUserById(2));
    }

    @Test
    public void testUpdateUser() {
        // Test case for updateUser method
        UserService userService = new UserService();
        User user = new User(1, "John Doe", "john.doe@example.com");
        userService.updateUser(user);
        assertEquals(user, userService.getUserById(1));
    }

    @Test
    public void testDeleteUser() {
        // Test case for deleteUser method
        UserService userService = new UserService();
        userService.deleteUser(1);
        assertNull(userService.getUserById(1));
    }
}