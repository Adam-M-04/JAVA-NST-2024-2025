package org.example.projectmanagerapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.projectmanagerapp.entity.User;
import org.example.projectmanagerapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Operacje na uzytkownikach")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Pobierz wszystkich użytkowników")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Dodaj nowego użytkownika")
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Zaktualizuj użytkownika")
    @PutMapping("/{id}")
    public User updateUser(
            @Parameter(description = "user ID do zmiany")@PathVariable Long id,
            @Parameter(description = "nowe dane")@RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @Operation(summary = "Usuń użytkownika")
    @DeleteMapping("/{id}")
    public void deleteUser(@Parameter(description = "user ID do usuniecia")@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @Operation(summary = "Pobierz użytkownika po ID")
    @GetMapping("/{id}")
    public User getUserById(
            @Parameter(description = "User id do wyszukania") @PathVariable Long id
    ) {
        return userService.getUserById(id);
    }
}
