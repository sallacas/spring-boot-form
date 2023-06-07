package com.springboot.form.app.models.domain;

import jakarta.validation.constraints.NotEmpty;

public record Users(
        @NotEmpty String username,
        @NotEmpty String password,
        @NotEmpty String email) {
}
