package com.example.oslash.demo.service;

import com.example.oslash.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class UserServiceTest {
    @Test
    public void whenCreateUserHasValidDataThenReturnNewUser() throws Exception
    {
        UserService us = Mockito.mock(UserService.class);
        User testUser = new User(0L, "test", "test@gmail.com", "test");
        User returnedUser = us.createUser(testUser);
        Assert.assertEquals(testUser.getName(), returnedUser.getName());
    }
}
