package com.model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

public class UserBuilder {

    public static User createRandomUser(int charactersAmount) {
        User user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(charactersAmount).toLowerCase()+"@testemail.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(charactersAmount));
        user.setName(RandomStringUtils.randomAlphabetic(charactersAmount));
        return user;
    }
}
