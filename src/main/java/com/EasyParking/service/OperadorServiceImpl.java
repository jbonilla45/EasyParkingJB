package com.EasyParking.service;

import com.EasyParking.entity.Operador;
import com.EasyParking.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperadorServiceImpl implements OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Operador> listarOperador() {
        return (List<Operador>) operadorRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Operador operador) {
        operadorRepository.save(operador);
    }

    @Override
    @Transactional
    public void eliminarOperador(Operador operador) {
        operadorRepository.delete(operador);
    }

    @Override
    @Transactional(readOnly = true)
    public Operador encontrarOperador(Operador operador) {
        return operadorRepository.findById(operador.getIdoperador()).orElse(null);
    }
}
