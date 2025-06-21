package contactlist.newproject.usecontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.contact.contactlist.Service.UserService;
import com.contact.contactlist.model.ContactPage;
import com.contact.contactlist.model.LoginUser;
import com.contact.contactlist.model.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://contactsvikky.netlify.app", allowCredentials = "true")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUser loginUser) {
        try {
            if (loginUser.getEmailLogin() == null || loginUser.getEmailLogin().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email must not be null or empty.");
            }
            Boolean isValid = userService.isValidUser(loginUser);
            if (isValid) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
        	if(userService.checkReg(user)) {
        		String[] error= {"Email is already exist"};
        		user.setErrors(error);
        		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Already exist"+" "+Arrays.toString(user.getErrors()));
        	}else {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        	}
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

//    @GetMapping("/contacts")
//    public ResponseEntity<List<ContactPage>> allContacts() {
//        List<ContactPage> contacts = userService.allContacts();
//        if (!contacts.isEmpty()) {
//            return ResponseEntity.ok(contacts);
//        } else {
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        }
//    }

    @PostMapping("/addcontacts")
    public ResponseEntity<ContactPage> createContacts(@RequestBody ContactPage contactPage) {
        try {
            ContactPage createdContact = userService.createContact(contactPage);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
