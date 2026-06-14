package com.dydko.testsupport;

import com.dydko.models.User;

public class TestContext {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}