package org.example.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AlunoModel {
    private static final double MEDIA_MINIMA = 70.0;
    
    private String nome;
    private long matricula;
    private List<DisciplinaModel> disciplinas = new ArrayList<>();
    private Map<Long, List<Double>> notasPorDisciplina = new HashMap<>();
    private List<EstagioModel> estagios = new ArrayList<>();

    public AlunoModel(String nome, long matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public boolean adicionarDisciplina(DisciplinaModel disciplina) {
        for (DisciplinaModel d : disciplinas) {
            if (d.getCodigo() == disciplina.getCodigo()) {
                return false;
            }
        }
        disciplinas.add(disciplina);
        notasPorDisciplina.put(disciplina.getCodigo(), new ArrayList<>());
        return true;
    }

    public boolean adicionarNotaDisciplina(long codigoDisciplina, double nota) {
        if (nota < 0 || nota > 100) {
            return false;
        }
        if (!notasPorDisciplina.containsKey(codigoDisciplina)) {
            return false;
        }
        notasPorDisciplina.get(codigoDisciplina).add(nota);
        return true;
    }

    public List<Double> obterNotasDisciplina(long codigoDisciplina) {
        return notasPorDisciplina.getOrDefault(codigoDisciplina, new ArrayList<>());
    }

    public double calcularMediaDisciplina(long codigoDisciplina) {
        List<Double> notas = obterNotasDisciplina(codigoDisciplina);
        if (notas.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }

    public boolean podeCalcularMediaDisciplina(long codigoDisciplina) {
        return obterNotasDisciplina(codigoDisciplina).size() >= 2;
    }

    public boolean aprovadoEmDisciplina(long codigoDisciplina) {
        if (!podeCalcularMediaDisciplina(codigoDisciplina)) {
            return false;
        }
        return calcularMediaDisciplina(codigoDisciplina) >= MEDIA_MINIMA;
    }

    public double getMediaMinima() {
        return MEDIA_MINIMA;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " (M - " + matricula + ")";
    }

    public boolean adicionarEstagio(EstagioModel estagio) {
        for (EstagioModel e : estagios) {
            if (e.getNome().equals(estagio.getNome())) {
                return false;
            }
        }
        estagios.add(estagio);
        return true;
    }
    public List<EstagioModel> getEstagios() {
        return estagios;
    }


}
