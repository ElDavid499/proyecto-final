package com.corhuila.deporte.models.services;

import com.corhuila.deporte.models.entity.Deporte;

import java.util.List;

public interface IDeporteService {
  public List<Deporte> findAll();

  public Deporte findById(Long id);

  public Deporte save(Deporte deporte);

  public void delete(Long id);
}
