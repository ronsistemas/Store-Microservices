package com.ordex.store.customer.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El número del documento no puede estar vacío")
    @Size( min = 8, max = 8, message = "El tamaño del número de documento es 8")
    @Column(name="number_id", unique = true, length=8, nullable=false)
    private String numberId;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Column(name="first_name", nullable=false)
    private String firstName;

    @NotEmpty(message = "El apellido no puede estar vacío")
    @Column(name="last_name", nullable=false)
    private String lastName;

    @NotEmpty(message="El correo no puede estar vacío")
    @Email(message="El correo no es una dirección de correo bien formada")
    @Column(unique=true, nullable=false)
    private String email;

    @Column(name="photo_url")
    private String photoUrl;

    @NotNull(message="La región no puede estar vacía")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="region_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    private String state;
}
