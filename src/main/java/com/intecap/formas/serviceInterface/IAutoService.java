package com.intecap.formas.serviceInterface;

import com.intecap.formas.modelo.Auto;

import java.util.List;
import java.util.Optional;

public interface IAutoService {

    public List<Auto> listar_auto();
    public Optional<Auto> listarIdAuto(int id);
    public int guardar(Auto a);
    public void borrar(int id);
}
