package com.api.crud.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {
    // JpaRepository proporciona métodos CRUD básicos para la entidad Person
    // No es necesario implementar ningún método adicional aquí, ya que JpaRepository maneja las operaciones CRUD automáticamente
    // Puedes agregar métodos personalizados si es necesario, pero no son obligatorios
    // Por ejemplo, puedes agregar un método para buscar personas por nombre:
    // List<Person> findByName(String name);
    // Esto generará automáticamente una consulta para buscar personas por su nombre
    // Puedes personalizar la consulta según tus necesidades
    // List<Person> findByLastName(String lastName);
    

}
