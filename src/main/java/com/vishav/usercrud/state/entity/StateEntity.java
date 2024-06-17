package com.vishav.usercrud.state.entity;

import com.vishav.usercrud.country.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "state")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;
}