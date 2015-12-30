package com.codechris.friends;

import java.security.PrivateKey;

/**
 * Created by Christopher on 12/29/2015.
 */
public class Friend {
    private int _id;
    private String name;
    private String phone;
    private String email;

    public Friend(int _id, String name, String phone, String email) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
