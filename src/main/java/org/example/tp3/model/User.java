package org.example.tp3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.UUID;
@AllArgsConstructor
@Getter
public final class User {

    @NonNull
    private final UUID id;
    @NonNull
    private final String name;
    @NonNull
    private final String email;
    @NonNull
    private final String role; // cargo

    public User withEmail(String newEmail) {
        return new User(this.id, this.name, newEmail, this.role);
    }

    public User withRole(String newRole) {
        return new User(this.id, this.name, this.email, newRole);
    }
}

