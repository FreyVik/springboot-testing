package com.freyvik.springboot_testing.rest.app.usuario.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "address_type")
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    private User user;
}
