package com.company.qlns.service.user;

import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.security.entity.UserRole;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Random;

@Service(UserService.NAME)
public class UserServiceBean implements UserService {
    @Inject
    protected PasswordEncryption passwordEncryption;
    @Inject
    private Metadata metadata;
    @Inject
    private DataManager dataManager;
    @Inject
    protected EmailService emailService;

    @Override
    public void createUser(String userName, String password) {
        User user = metadata.create(User.class);
        user.setLogin(userName);
        user.setLogin(userName);
        user.setPassword(passwordEncryption.getPasswordHash(user.getId(), password));
        UserRole userRole = metadata.create(UserRole.class);
        userRole.setUser(user);
        Role role = dataManager.load(Role.class).query("select e from sec$Role e where e.name = :nameRole")
                .parameter("nameRole", "ungvien").one();
        userRole.setRole(role);
        dataManager.commit(user);
    }

    @Override
    public void sendEmail(String Addresses, String caption,String body){
        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(Addresses)
                .setCaption(caption + " : " + randomString())
                .setFrom(null)
                .setBody(body)
                .build();
        emailService.sendEmailAsync(emailInfo);
    }

    public String randomString() {
        // create a string of all characters
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 6;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}