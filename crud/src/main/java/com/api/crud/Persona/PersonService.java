package com.api.crud.Persona;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
// La anotación @Service indica que esta clase es un componente de servicio en el contexto de Spring.
// La anotación @RequiredArgsConstructor genera un constructor con los argumentos requeridos (campos finales).
public class PersonService {
    private final PersonRepository personRepository;
    // El campo final personRepository se inyecta a través del constructor.
    // Esto permite que el servicio interactúe con la capa de repositorio para el acceso a datos.
    public void createPerson(Person person) {
            // Este método se encarga de crear una nueva persona en la base de datos.
            // Recibe un objeto Person como parámetro.
            // Se espera que el objeto Person contenga los datos necesarios para crear una nueva entrada en la base de datos.
            // La lógica de negocio para crear una persona se implementa aquí.
            // Se puede agregar validación o transformación de datos si es necesario.
            // Por simplicidad, este método solo llama al repositorio para guardar la entidad.

       personRepository.save(person);
         // Se llama al método save del personRepository para persistir la entidad Person en la base de datos.
    }
    public Person getPersonById(Integer id) {
        return personRepository.findById(id)//aquí se busca la persona por id
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));//si no se encuentra la persona, se lanza una excepción
        // Se utiliza el método findById del personRepository para buscar la entidad Person por su ID.
    }

    public Person updatePerson(Integer id, Person updatedPerson) { //Aqui se debe enviar un objeto Person con los datos actualizados y el id de la persona a actualizar
        // Este método se encarga de actualizar una persona existente en la base de datos.
        Person person = getPersonById(id);
        person.setName(updatedPerson.getName()); //actualiza el nombre de la persona
        person.setLastName(updatedPerson.getLastName()); //actualiza el apellido de la persona
        person.setEmail(updatedPerson.getEmail());//actualiza el email de la persona
        return personRepository.save(person);//guarda la persona actualizada en la base de datos
        // Se llama al método save del personRepository para persistir la entidad Person en la base de datos.
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);//elimina la persona de la base de datos
        // Se llama al método deleteById del personRepository para eliminar la entidad Person de la base de datos.
    }
}
