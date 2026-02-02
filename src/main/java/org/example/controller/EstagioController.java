package org.example.controller;

import org.example.model.EstagioModel;
import java.util.ArrayList;
import java.util.List;


public class EstagioController {
        private List<EstagioModel> estagios = new ArrayList<>();
    
    public boolean cadastrar(EstagioModel estagio) {
        for (EstagioModel e : estagios) {
            if (e.getNome().equals(estagio.getNome())) {
                return false; 
            }
        }
        estagios.add(estagio);
        return true;
    }
    
    public List<EstagioModel> listarEstagios() {
        return new ArrayList<>(estagios);
    }    
}
