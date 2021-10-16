package com.EasyParking.service;

import com.EasyParking.entity.Operador;

import java.util.List;

public interface OperadorService {

    public List <Operador> listarOperador();
    public void guardar(Operador operador);
    public void eliminarOperador(Operador operador);
    public Operador encontrarOperador(Operador operador);
}
