package org.example;

import java.util.Scanner;

import org.example.view.AlunoView;
import org.example.controller.AlunoController;

import org.example.view.ProfessorView;
import org.example.controller.ProfessorController;

public class AppSisAcad {
    public static void main(String[] args) {

        AlunoController alunoCtrl = new AlunoController();
        AlunoView alunoView = new AlunoView();
        
        ProfessorController profCtrl = new ProfessorController();
        ProfessorView profView = new ProfessorView();

        Scanner keyboard = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n Menu de sistema acad");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Cadastrar Professor");
            System.out.println("4. Listar Professores");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = keyboard.nextLine();
                    System.out.print("Matrícula: ");
                    long matricula = keyboard.nextLong();
                    // USA O CONTROLLER DE ALUNO
                    if (alunoCtrl.adicionarAluno(nome, matricula)) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: Matrícula já existe.");
                    }
                    break;
                
                case 2:
                    alunoView.exibirListaAlunos(alunoCtrl.listarAlunos());
                    break;
                
                case 3:
                    System.out.print("Nome do Professor: ");
                    String nomeP = keyboard.nextLine();
                    System.out.print("Matrícula do Professor: ");
                    long idP = keyboard.nextLong();
                    if (profCtrl.adicionarProfessor(nomeP, idP)) {
                        System.out.println("Professor cadastrado com sucesso!");
                    } else {
                         System.out.println("Erro: Professor com este ID já existe.");
                    }
                    break;
                
                case 4:
                    profView.exibirListaProfessores(profCtrl.listarProfessores());
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            } 
        }
        keyboard.close();
    }
}