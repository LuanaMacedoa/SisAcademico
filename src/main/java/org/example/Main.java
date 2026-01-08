package org.example;

import java.util.Scanner;

import org.example.controller.AlunoController;
import org.example.view.AlunoView;

public class Main {
    public static void main(String[] args) {

        AlunoController controller = new AlunoController();
        AlunoView view = new AlunoView();

        Scanner keyboard = new Scanner(System.in);

        // INFO: menu provisorio
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n Menu de sistema acad");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = keyboard.nextInt();
            keyboard.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = keyboard.nextLine();
                    System.out.print("Digite a matrícula do aluno: ");
                    long matricula = keyboard.nextLong();
                    if (controller.adicionarAluno(nome, matricula)) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                         System.out.println("Erro: Aluno com este nome ou matrícula já existe.");
                    }
                    break;
                
                case 2:
                    view.exibirListaAlunos(controller.listarAlunos());
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