package com.vishav.usercrud.country.entity;

import com.vishav.usercrud.state.entity.StateEntity;
import com.vishav.usercrud.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "cuid", columnDefinition="VARCHAR(255)")
    private String cuid;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<StateEntity> states;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<User> users;

    @PrePersist
    public void generateCuid() {
        if (cuid == null) {
            cuid = UUID.randomUUID().toString();
        }
    }
}