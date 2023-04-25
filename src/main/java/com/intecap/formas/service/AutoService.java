package com.intecap.formas.service;

import com.intecap.formas.modelo.Auto;
import com.intecap.formas.modeloDAO.IAuto;
import com.intecap.formas.serviceInterface.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService implements IAutoService {


    @Autowired
    private IAuto dao;


    @Override
    public List<Auto> listar_auto() {
        return (List<Auto>) dao.findAll();
    }

    @Override
    public Optional<Auto> listarIdAuto(int id) {
        return dao.findById(id);
    }

    @Override
    public int guardar(Auto a) {
        int res=0;
        Auto aut =dao.save(a);
        if (!aut.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void borrar(int id) {
    dao.deleteById(id);
    }
}
