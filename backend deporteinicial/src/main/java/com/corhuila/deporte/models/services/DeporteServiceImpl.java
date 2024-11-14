package com.corhuila.deporte.models.services;

import com.corhuila.deporte.models.dao.IDeporteDao;
import com.corhuila.deporte.models.entity.Deporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {
    @Autowired
    private IDeporteDao deporteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Deporte> findAll() {
        return (List<Deporte>) deporteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Deporte findById(Long id) {
        return deporteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Deporte save(Deporte deporte) {
        return deporteDao.save(deporte);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        deporteDao.deleteById(id);
    }
}
