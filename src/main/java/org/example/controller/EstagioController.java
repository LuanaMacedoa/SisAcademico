package org.example.controller;

import org.example.model.EstagioModel;
import java.util.ArrayList;
import java.util.List;


public class EstagioController {
        private List<EstagioModel> estagios = new ArrayList<>();
    
    public boolean adicionarEstagio(String nome, String descricao) {
        for (EstagioModel e : estagios) {
            if (e.getNome() == nome && e.getDescricao() == descricao) {
                return false; 
            }
        }
    
        estagios.add(new EstagioModel(nome, descricao));
        return true;
    }
    
    public List<EstagioModel> listarEstagios() {
        return new ArrayList<>(estagios);
    }    
}
