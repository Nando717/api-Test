package com.nando.api_rest.domains;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
@Table(name = "tb_users")
public class User implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String email;
    private String password;






}
