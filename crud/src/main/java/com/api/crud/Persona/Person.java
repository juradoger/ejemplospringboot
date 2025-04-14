package com.api.crud.Persona;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //genera los getters y setters automáticamente
@AllArgsConstructor //constructor con todos los atributos
@NoArgsConstructor //constructor sin atributos
@Entity
public class Person {
    //Atributos de la clase
    //id es la clave primaria y se autoincrementa
    //la anotación @GeneratedValue indica que el valor se generará automáticamente
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    //la estrategia de generación de valores es IDENTITY, lo que significa que la base de datos generará el valor automáticamente
    //en la base de datos, el id es un campo autoincremental
    private Integer id;

    @Basic(optional = false) //el campo no puede ser nulo
    //la anotación @Basic indica que el campo es básico y no puede ser nulo
    private String name;
    private String lastName;
    private String email;
}
