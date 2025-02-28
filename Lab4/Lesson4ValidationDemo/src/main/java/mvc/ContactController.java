package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ContactController {

    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    public ContactController() {
        contacts.put("Frank", new Contact("Frank", "Brown", "fbrown@acme.com", "2341678453"));
        contacts.put("Mary", new Contact("Mary", "Jones", "mjones@acme.com", "2341674376"));
    }

    @GetMapping("/contacts/{firstName}")
    public ResponseEntity<?> getContact(@PathVariable String firstName) {
        Contact contact = contacts.get(firstName);
        if (contact == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstname= "
                    + firstName + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @PostMapping("/contacts")
    public ResponseEntity<?> addContact(@RequestBody @Valid Contact contact) {
        contacts.put(contact.getFirstName(), contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @DeleteMapping("/contacts/{firstName}")
    public ResponseEntity<?> deleteContact(@PathVariable String firstName) {
        Contact contact = contacts.get(firstName);
        if (contact == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstname= " + firstName + " is not available"),HttpStatus.NOT_FOUND);
        }
        contacts.remove(firstName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/contacts/{firstName}")
    public ResponseEntity<?> updateContact(@PathVariable String firstName, @RequestBody @Valid Contact contact) {
        contacts.put(firstName, contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @GetMapping("/contacts")
    public ResponseEntity<?> getAllContacts() {
        Contacts allcontacs = new Contacts(contacts.values());
        return new ResponseEntity<Contacts>(allcontacs, HttpStatus.OK);
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        System.out.println("******************************************");
//        System.out.println(ex.getBindingResult().getFieldErrors());
//        Map<String, Object> fieldError = new HashMap<>();
//        List<FieldError> fieldErrors= ex.getBindingResult().getFieldErrors();
//        for (FieldError error : fieldErrors) {
//            fieldError.put(error.getField(), error.getDefaultMessage());
//        }
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("isSuccess", false);
//        map.put("data", null);
//        map.put("status", HttpStatus.BAD_REQUEST);
//        map.put("fieldError", fieldError);
//        return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
//    }
}
