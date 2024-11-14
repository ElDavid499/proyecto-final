package com.corhuila.deporte.models.dao;

import com.corhuila.deporte.models.entity.Deporte;
import org.springframework.data.repository.CrudRepository;

public interface IDeporteDao extends CrudRepository<Deporte, Long> {
}
