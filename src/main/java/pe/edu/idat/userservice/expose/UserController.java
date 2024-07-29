package pe.edu.idat.userservice.expose;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.idat.userservice.model.User;
import pe.edu.idat.userservice.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        if (user == null || user.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addOrUpdateUser(user));
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        if (user == null || user.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userService.addOrUpdateUser(user));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        var user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

}
