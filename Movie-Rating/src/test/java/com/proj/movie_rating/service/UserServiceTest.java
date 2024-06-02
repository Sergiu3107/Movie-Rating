package com.proj.movie_rating.service;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.repository.UserRepository;
import org.junit.*;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepoMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepoMock);
    }

    @Test
    public void getUserTest() {

        User user = new User(1, "user1", "pass1", "this1@gmail.com", "regular");
        when(userRepoMock.findById(1)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1);

        assertEquals(result, user);
        verify(userRepoMock).findById(1);
    }

    @Test
    public void getAllUsersTest() {

        List<User> users = Arrays.asList(
                new User(1, "user1", "pass1", "this1@gmail.com", "regular"),
                new User(2, "user2", "pass2", "this2@gmail.com", "regular"),
                new User(3, "user3", "pass3", "this3@gmail.com", "regular"),
                new User(4, "admin1", "adminpass", "admin1@gmail.com", "admin")
        );

        when(userRepoMock.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(result, users);
        verify(userRepoMock).findAll();
    }

    @Test
    public void deleteAUserTest() {

        when(userRepoMock.existsById(1)).thenReturn(true);

        boolean result = userService.deleteAUser(1);

        assertTrue(result);
        verify(userRepoMock).deleteById(1);
    }

    @Test
    public void postUserTest(){

        User userTest = new User(1, "userTest", "passTest", "test@gmail.com", "regular");

        when(userRepoMock.save(userTest)).thenReturn(userTest);

        userService.postUser(userTest);
        verify(userRepoMock).save(userTest);

    }

    @Test
    public void putUserTest() {

        User user = new User(1, "user1", "pass1", "this1@gmail.com", "regular");

        when(userRepoMock.existsById(1)).thenReturn(true);
        when(userRepoMock.findById(1)).thenReturn(Optional.of(user));

        User updatedUser = new User(1, "updatedUser", "updatedPassword", "updated@example.com", "user");
        boolean result = userService.putUser(1, updatedUser);

        assertTrue(result);
        verify(userRepoMock).save(user);

    }

    @Test
    public void updateUsernameTest(){

        User userTest = new User(1, "userTest", "passTest", "test@gmail.com", "regular");
        userService.postUser(userTest);

        User updatedUser = new User(1, "updatedUser", "updatedPassword", "updated@example.com", "user");
        userService.putUser(1, updatedUser);

        User user = userService.getUserById(1);

        assertEquals(user.getUsername(), updatedUser.getUsername());
    }

    @Test
    public void updatePasswordTest(){

        User userTest = new User(1, "userTest", "passTest", "test@gmail.com", "regular");
        userService.postUser(userTest);

        User updatedUser = new User(1, "updatedUser", "updatedPassword", "updated@example.com", "user");
        userService.putUser(1, updatedUser);

        User user = userService.getUserById(1);

        assertEquals(user.getPassword(), updatedUser.getPassword());
    }


}
