package com.dklb.filius.infrastructure.driven_adapter.database.admin;

import com.dklb.filius.infrastructure.helpers.enums.RoleEnum;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "admins")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String businessId;
    private String name;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    private LocalDateTime dateCreated;

}
