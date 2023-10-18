package com.pl.shop.shop.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    private String password;
    private String email;
    private boolean archive;
    @Enumerated(EnumType.STRING)
    private Role role;
    //@OneToOne(cascade = CascadeType.REMOVE)
    //private Bucket bucket;
    // Добавьте поле "bucket_id" и связь с сущностью Bucket
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "bucket_id") // Укажите имя столбца, с которым будет установлена связь
    private Bucket bucket;

}