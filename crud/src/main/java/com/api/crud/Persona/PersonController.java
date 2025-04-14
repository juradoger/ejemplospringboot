package com.api.crud.Persona;
//aqui se publican todas las rutas 

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor //la anotación @RequiredArgsConstructor genera un constructor con los argumentos requeridos (campos finales)
@RestController //la anotación @RestController indica que esta clase es un controlador REST
// y manejará las solicitudes HTTP relacionadas con la entidad Person
@RequestMapping("/person") //la anotación @RequestMapping define la ruta base para este controlador

public class PersonController {

    private final PersonService personService; //se declara el servicio de persona
    @PostMapping //la anotación @PostMapping indica que este método manejará las solicitudes POST en la ruta especificada
    public void createPerson(@RequestBody Person person) {
        // Este método se encarga de crear una nueva persona en la base de datos.
        // Recibe un objeto Person como parámetro.
        // Se espera que el objeto Person contenga los datos necesarios para crear una nueva entrada en la base de datos.
        // La lógica de negocio para crear una persona se implementa aquí.
        // Se puede agregar validación o transformación de datos si es necesario.
        // Por simplicidad, este método solo llama al repositorio para guardar la entidad.
        // Se llama al método save del personRepository para persistir la entidad Person en la base de datos.  
        personService.createPerson(person);
    }
    @GetMapping("/{id}") //la anotación @GetMapping indica que este método manejará las solicitudes GET en la ruta especificada
    // y el id es el identificador de la persona que se desea obtener
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        return ResponseEntity.ok(personService.getPersonById(id));////se obtiene la persona por id
        // Se utiliza el método findById del personRepository para buscar la entidad Person por su ID.
    }

    @PutMapping("/{id}")
    //la anotación @PutMapping indica que este método manejará las solicitudes PUT en la ruta especificada
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person updatedPerson) {
        // Este método se encarga de actualizar una persona existente en la base de datos.
        // Recibe el ID de la persona a actualizar y un objeto Person con los datos actualizados.
        // Se espera que el objeto Person contenga los datos necesarios para actualizar la entrada en la base de datos.
        // La lógica de negocio para actualizar una persona se implementa aquí.
        return ResponseEntity.ok(personService.updatePerson(id, updatedPerson));////se actualiza la persona por id
        // Se llama al método save del personRepository para persistir la entidad Person en la base de datos.
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id); //el void indica que no se espera una respuesta del servidor, el @pathVariable indica que se espera un id en la url
        return ResponseEntity.noContent().build();////elimina la persona por id
        // Se llama al método deleteById del personRepository para eliminar la entidad Person de la base de datos.
        // Se devuelve una respuesta sin contenido (204 No Content) para indicar que la eliminación fue exitosa.
    }
}
