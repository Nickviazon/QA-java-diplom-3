package com.model;

import org.apache.commons.lang3.RandomStringUtils;

public class UserBuilder {

    public static User createRandomUser(int charactersAmount) {
        User user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(charactersAmount)+"@testemail.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(charactersAmount));
        user.setName(RandomStringUtils.randomAlphabetic(charactersAmount));
        return user;
    }
}
