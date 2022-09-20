package com.company.qlns.service.user;

import java.io.IOException;

public interface UserService {
    String NAME = "qlns_UserService";
    void createUser(String userName,String passWord);
    void sendEmail(String Addresses, String caption,String body) throws IOException;
}