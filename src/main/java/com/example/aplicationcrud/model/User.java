package com.example.aplicationcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tb")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}