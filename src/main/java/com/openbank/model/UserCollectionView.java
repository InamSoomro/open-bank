package com.openbank.model;

import java.util.Map;

//user lambok
public class UserCollectionView {

    private Map<String, User> userCollection;


    public Map<String, User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Map<String, User> userCollection) {
        this.userCollection = userCollection;
    }
}
