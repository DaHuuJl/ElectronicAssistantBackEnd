package ru.cchgeu.electronicassistantbackend.model.entity.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cchgeu.electronicassistantbackend.model.entity.user.User;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "SEC_USER_PERMISSIONS")
@NoArgsConstructor
public class UserPermissions {
    @Id
    @Column(name = "USER_PERMISSIONS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "SEC_PERMISSIONS_USER_PERMISSIONS_ID_SEQ_GEN")
    @SequenceGenerator(name = "SEC_PERMISSIONS_USER_PERMISSIONS_ID_SEQ_GEN",
            sequenceName = "SEC_PERMISSIONS_USER_PERMISSIONS_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "PERMISSION", nullable = false)
    @Enumerated(EnumType.STRING)
    private Permission permission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
