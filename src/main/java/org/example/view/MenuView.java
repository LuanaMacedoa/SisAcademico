package org.example.view;

import org.example.ui.Cores;
import java.util.Scanner;

public class MenuView implements Cores {
    private Scanner scanner;

    public MenuView(Scanner keyboard) {
        this.scanner = keyboard;
    }

    public void exibirMenu() {
        System.out.println(AZUL_BG + BRANCO + "\n╔════════════════════════════════════════╗" + RESET);
        System.out.println(AZUL_BG + BRANCO + "║    MENU DO SISTEMA ACADÊMICO         ║" + RESET);
        System.out.println(AZUL_BG + BRANCO + "╚════════════════════════════════════════╝" + RESET);
        System.out.println(CIANO + "\n[ALUNOS]" + RESET);
        System.out.println(VERDE + "  1." + RESET + " Cadastrar Aluno");
        System.out.println(VERDE + "  2." + RESET + " Listar Alunos");
        System.out.println(CIANO + "\n[PROFESSORES]" + RESET);
        System.out.println(VERDE + "  3." + RESET + " Cadastrar Professor");
        System.out.println(VERDE + "  4." + RESET + " Listar Professores");
        System.out.println(CIANO + "\n[DISCIPLINAS]" + RESET);
        System.out.println(VERDE + "  5." + RESET + " Cadastrar Disciplina");
        System.out.println(VERDE + "  6." + RESET + " Listar Disciplinas");
        System.out.println(CIANO + "\n[ESTÁGIOS]" + RESET);
        System.out.println(VERDE + "  7." + RESET + " Cadastrar Estágio");
        System.out.println(VERDE + "  8." + RESET + " Listar Estágios");
        System.out.println(CIANO + "\n[MATRÍCULAS E AVALIAÇÕES]" + RESET);
        System.out.println(VERDE + "  9." + RESET + " Matricular Aluno em Disciplina");
        System.out.println(VERDE + " 10." + RESET + " Adicionar Notas a Disciplina");
        System.out.println(VERDE + " 11." + RESET + " Visualizar Desempenho do Aluno");
        System.out.println(VERDE + " 12." + RESET + " Matricular Aluno em Estágio");
        System.out.println(VERDE + " 13." + RESET + " Registrar Avaliação em Estágio");
        System.out.println(CIANO + "\n[RELATÓRIOS]" + RESET);
        System.out.println(VERDE + " 14." + RESET + " Listar Componentes Acadêmicos");
        System.out.println(VERDE + " 15." + RESET + " Visualizar Situação Acadêmica do Aluno");
        System.out.println(VERMELHO + "\n  0." + RESET + " Sair\n");
    }

    public int obterOpcao() {
        System.out.print(AZUL + "➤ Escolha uma opção: " + RESET);
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public String obterEntrada(String mensagem) {
        System.out.print(CIANO + mensagem + RESET);
        return scanner.nextLine();
    }

    public long obterLong(String mensagem) {
        System.out.print(CIANO + mensagem + RESET);
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

    public void exibirSucesso(String mensagem) {
        System.out.println(VERDE + mensagem + RESET);
    }

    public void exibirErro(String mensagem) {
        System.out.println(VERMELHO + mensagem + RESET);
    }

    public void exibirAviso(String mensagem) {
        System.out.println(CIANO + mensagem + RESET);
    }
}
