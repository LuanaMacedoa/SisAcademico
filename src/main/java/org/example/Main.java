package org.example;

import org.example.model.Aluno;

public class Main {
    public static void main(String[] args) {
        Aluno a = new Aluno("Vinícius", 20242370007L);
        a.getMatricula();
        a.getNome();
        a.toString();
    }
}