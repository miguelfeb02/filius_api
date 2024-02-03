package com.dklb.filius.infrastructure.driven_adapter.database.user;


import com.dklb.filius.infrastructure.helpers.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String businessId;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
    private Boolean active;
    private LocalDateTime dateCreated;
}
