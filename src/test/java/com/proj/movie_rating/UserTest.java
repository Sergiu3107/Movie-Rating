package com.proj.movie_rating;

import com.proj.movie_rating.model.User;
import com.proj.movie_rating.repository.UserRepository;
import com.proj.movie_rating.service.*;
import org.junit.*;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserTest {

    @Mock
    private UserRepository userRepoMock;

    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepoMock);
    }

    @Test
    public void saveUserTest(){

        User userTest = new User(
                1,
                "user_vasi_777",
                "11223344",
                "vasi1001@gmail.com",
                "admin"
        );

        userService.postUser(userTest);
        verify(userRepoMock).save(userTest);

    }

    @Test
    public void getAllUsersTest() {
        // Mocking UserRepository's behavior
        List<User> users = Arrays.asList(
                new User(1, "user1", "pass1", "this1@gmail.com", "regular"),
                new User(2, "user2", "pass2", "this2@gmail.com", "regular"),
                new User(3, "user3", "pass3", "this3@gmail.com", "regular"),
                new User(4, "admin1", "adminpass", "admin1@gmail.com", "admin")
        );
        when(userRepoMock.findAll()).thenReturn(users);

        // Calling the service method
        List<User> userList = userService.getAllUsers();

        // Verifying if the method was called and returned the correct value
        assertEquals(users.size(), userList.size());
        assertTrue(userList.containsAll(users));
    }

    @Test
    public void getUserTest() {
        // Mocking UserRepository's behavior
        User user = new User(1, "user1", "pass1", "this1@gmail.com", "regular");
        when(userRepoMock.findById(1)).thenReturn(Optional.of(user));

        // Calling the service method
        User returnedUser = userService.getUser(1);

        // Verifying if the method was called and returned the correct value
        assertNotNull(returnedUser);
        assertEquals(user, returnedUser);
    }

    @Test
    public void deleteAUserTest() {
        // Mocking UserRepository's behavior
        when(userRepoMock.existsById(1)).thenReturn(true);

        // Calling the service method
        boolean result = userService.deleteAUser(1);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(userRepoMock).deleteById(1);
    }

    @Test
    public void putUserTest() {
        // Mocking UserRepository's behavior
        User user = new User(1, "user1", "pass1", "this1@gmail.com", "regular");
        when(userRepoMock.existsById(1)).thenReturn(true);
        when(userRepoMock.findById(1)).thenReturn(Optional.of(user));

        // Updating user details
        User updatedUser = new User(1, "updatedUser", "updatedPassword", "updated@example.com", "user");

        // Calling the service method
        boolean result = userService.putUser(1, updatedUser);

        // Verifying if the method was called and returned the correct value
        assertTrue(result);
        verify(userRepoMock).save(user);
        assertEquals(updatedUser.getUsername(), user.getUsername());
        assertEquals(updatedUser.getPassword(), user.getPassword());
    }

}
