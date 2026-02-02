package org.example.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView(Scanner keyboard) {
        this.scanner = keyboard;
    }

    public void exibirMenu() {
        System.out.println("\nMenu do Sistema Acadêmico");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Listar Alunos");
        System.out.println("3. Cadastrar Professor");
        System.out.println("4. Listar Professores");
        System.out.println("5. Cadastrar Disciplina");
        System.out.println("6. Listar Disciplinas");
        System.out.println("7. Cadastrar Estágio");
        System.out.println("8. Listar Estágios");
        System.out.println("9. Matricular Aluno em Disciplina");
        System.out.println("10. Adicionar Notas a Disciplina");
        System.out.println("11. Visualizar Desempenho do Aluno");
        System.out.println("0. Sair");
    }

    public int obterOpcao() {
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public String obterEntrada(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public long obterLong(String mensagem) {
        System.out.print(mensagem);
        long valor = scanner.nextLong();
        scanner.nextLine();
        return valor;
    }

    public int obterInt(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public double obterDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
