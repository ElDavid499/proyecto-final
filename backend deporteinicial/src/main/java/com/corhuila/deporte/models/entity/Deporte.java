package com.corhuila.deporte.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "deportes")
public class Deporte implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100)
  private String nombre;

  @Column(name = "jugadores_por_equipo")
  private Integer jugadoresPorEquipo;

  @Column(name = "duracion_del_partido") // in minutes
  private String duracionDelPartido;

  @Column(name = "popularidad_global")
  private String popularidadGlobal;

  private String origen;

  private static final long serialVersionUID = 1L;

  // Getters and Setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public Integer getJugadoresPorEquipo() {
    return jugadoresPorEquipo;
  }

  public void setJugadoresPorEquipo(Integer jugadoresPorEquipo) {
    this.jugadoresPorEquipo = jugadoresPorEquipo;
  }

  public String getDuracionDelPartido() {
    return duracionDelPartido;
  }

  public void setDuracionDelPartido(String duracionDelPartido) {
    this.duracionDelPartido = duracionDelPartido;
  }

  public String getPopularidadGlobal() {
    return popularidadGlobal;
  }

  public void setPopularidadGlobal(String popularidadGlobal) {
    this.popularidadGlobal = popularidadGlobal;
  }

  public String getOrigen() {
    return origen;
  }

  public void setOrigen(String origen) {
    this.origen = origen;
  }
}
