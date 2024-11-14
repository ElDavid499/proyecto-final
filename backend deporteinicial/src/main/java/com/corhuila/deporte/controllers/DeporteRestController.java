package com.corhuila.deporte.controllers;

import com.corhuila.deporte.models.entity.Deporte;
import com.corhuila.deporte.models.services.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}) // Permite acceso desde el frontend Angular (puerto 4200)
@RestController
@RequestMapping("/api")
public class DeporteRestController {

  @Autowired
  private IDeporteService deporteService;

  // Obtener todos los deportes
  @GetMapping("/deportes")
  public List<Deporte> index() {
    return deporteService.findAll();
  }

  // Obtener un deporte por su ID
  @GetMapping("/deportes/{id}")
  public Deporte show(@PathVariable Long id) {
    return deporteService.findById(id);
  }

  // Crear un nuevo deporte
  @PostMapping("/deportes")
  @ResponseStatus(HttpStatus.CREATED)
  public Deporte create(@RequestBody Deporte deporte) {
    return deporteService.save(deporte);
  }

  // Actualizar un deporte existente
  @PutMapping("/deportes/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Deporte update(@RequestBody Deporte deporte, @PathVariable Long id) {
    Deporte deporteActual = deporteService.findById(id);

    // Actualizamos los campos del deporte con los valores del request
      deporteActual.setNombre(deporte.getNombre());
      deporteActual.setDuracionDelPartido(deporte.getDuracionDelPartido());
      deporteActual.setJugadoresPorEquipo(deporte.getJugadoresPorEquipo());
      deporteActual.setPopularidadGlobal(deporte.getPopularidadGlobal());
      deporteActual.setOrigen(deporte.getOrigen());
      //deporteActual.setDescripcion(deporte.getDescripcion());
      //deporteActual.setResponsable(deporte.getResponsable());
      //deporteActual.setEmail(deporte.getEmail());


    return deporteService.save(deporteActual);
  }

  // Eliminar un deporte
  @DeleteMapping("/deportes/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    deporteService.delete(id);
  }
}
