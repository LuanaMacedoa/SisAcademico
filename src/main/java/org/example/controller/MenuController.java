package org.example.controller;

import java.util.List;

import org.example.model.EstagioModel;
import org.example.view.AlunoView;
import org.example.view.DisciplinaView;
import org.example.view.EstagioView;
import org.example.view.MenuView;
import org.example.view.ProfessorView;
import org.example.model.AlunoModel;
import org.example.model.DisciplinaModel;
import org.example.exception.AlunoNaoMatriculadoEmEstagioException;
import org.example.exception.NotasInsuficientesException;

public class MenuController {
    private MenuView menuView;
    private AlunoController alunoCtrl;
    private AlunoView alunoView;
    private ProfessorController profCtrl;
    private ProfessorView profView;
    private DisciplinaController discipCtrl;
    private DisciplinaView discipView;
    private EstagioController estagCtrl;
    private EstagioView estagView;

    public MenuController(MenuView menuView, AlunoController alunoCtrl, AlunoView alunoView,
                         ProfessorController profCtrl, ProfessorView profView,
                         DisciplinaController discipCtrl, DisciplinaView discipView,
                         EstagioController estagCtrl, EstagioView estagView) {
        this.menuView = menuView;
        this.alunoCtrl = alunoCtrl;
        this.alunoView = alunoView;
        this.alunoView.setMenuView(menuView);
        this.profCtrl = profCtrl;
        this.profView = profView;
        this.profView.setMenuView(menuView);
        this.discipCtrl = discipCtrl;
        this.discipView = discipView;
        this.discipView.setMenuView(menuView);
        this.estagCtrl = estagCtrl;
        this.estagView = estagView;
        this.estagView.setMenuView(menuView);
    }

    public void executarFluxo(int opcao) {
        switch (opcao) {
            case 1: {
                AlunoModel aluno = alunoView.obterDadosCadastro();
                if (alunoCtrl.cadastrar(aluno)) {
                    menuView.exibirSucesso("Aluno cadastrado com sucesso!");
                } else {
                    menuView.exibirErro("Matrícula já existe.");
                }
                break;
            }

            case 2:
                alunoView.exibirListaAlunos(alunoCtrl.listarAlunos());
                break;

            case 3: {
                var professor = profView.obterDadosCadastro();
                if (profCtrl.cadastrar(professor)) {
                    menuView.exibirSucesso("Professor cadastrado com sucesso!");
                } else {
                    menuView.exibirErro("Professor com este ID já existe.");
                }
                break;
            }

            case 4:
                profView.exibirListaProfessores(profCtrl.listarProfessores());
                break;

            case 5: {
                if (profCtrl.listarProfessores().isEmpty()) {
                    menuView.exibirErro("Não há professores cadastrados. Cadastre um professor primeiro.");
                    break;
                }
                DisciplinaModel disciplina = discipView.obterDadosCadastro();
                if (discipCtrl.cadastrar(disciplina)) {
                    menuView.exibirSucesso("Disciplina cadastrada com sucesso!");
                } else {
                    menuView.exibirErro("Disciplina com este nome já existe.");
                }
                break;
            }

            case 6:
                discipView.exibirListaDisciplinas(discipCtrl.listarDisciplinas());
                break;

            case 7: {
                List<DisciplinaModel> disciplinas = discipCtrl.listarDisciplinas();
                if (disciplinas.isEmpty()) {
                    menuView.exibirAviso("Nenhuma disciplina cadastrada.");
                    break;
                }

                List<org.example.model.ProfessorModel> professores = profCtrl.listarProfessores();
                if (professores.isEmpty()) {
                    menuView.exibirAviso("Nenhum professor cadastrado.");
                    break;
                }

                long codigoDisciplina = discipView.obterCodigoDisciplina(disciplinas);
                DisciplinaModel disciplina = discipCtrl.buscarDisciplinaPorCodigo(codigoDisciplina);

                if (disciplina == null) {
                    menuView.exibirErro("Disciplina não encontrada.");
                    break;
                }

                profView.exibirListaProfessores(professores);
                long matriculaProfessor = menuView.obterLong("Digite a matrícula do professor: ");

                org.example.model.ProfessorModel professor = profCtrl.buscarProfessorPorMatricula(matriculaProfessor);
                if (professor == null) {
                    menuView.exibirErro("Professor não encontrado.");
                    break;
                }

                if (discipCtrl.vincularProfessorADisciplina(codigoDisciplina, professor)) {
                    menuView.exibirSucesso("Professor vinculado à disciplina com sucesso!");
                } else {
                    menuView.exibirErro("Erro ao vincular professor à disciplina.");
                }
                break;
            }

            case 8: {
                var estagio = estagView.obterDadosCadastro();
                if (estagCtrl.cadastrar(estagio)) {
                    menuView.exibirSucesso("Estágio cadastrado com sucesso!");
                } else {
                    menuView.exibirErro("Estágio com este nome já existe.");
                }
                break;
            }

            case 9:
                estagView.exibirListaEstagios(estagCtrl.listarEstagios());
                break;
            case 10: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                List<DisciplinaModel> disciplinas = discipCtrl.listarDisciplinas();
                if (disciplinas.isEmpty()) {
                    menuView.exibirAviso("Nenhuma disciplina cadastrada.");
                    break;
                }

                AlunoModel alunoMatricula = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoMatricula.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }

                int opcDisciplina = discipView.obterDisciplinaEscolhida(disciplinas);

                if (opcDisciplina < 1 || opcDisciplina > disciplinas.size()) {
                    menuView.exibirErro("Opção de disciplina inválida.");
                    break;
                }

                DisciplinaModel disciplinaSelecionada = disciplinas.get(opcDisciplina - 1);
                if (alunoCtrl.matricularAlunoEmDisciplina(alunoMatricula.getMatricula(), disciplinaSelecionada)) {
                    menuView.exibirSucesso("Aluno matriculado com sucesso!");
                } else {
                    menuView.exibirErro("Aluno já matriculado nesta disciplina.");
                }
                break;
            }

            case 0:
                menuView.exibirAviso("Encerrando sistema...");
                break;

            case 11: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }

                if (alunoBuscado.getDisciplinas().isEmpty()) {
                    menuView.exibirAviso("Este aluno não possui disciplinas matriculadas.");
                    break;
                }

                System.out.println("\nDisciplinas do aluno:");
                for (int i = 0; i < alunoBuscado.getDisciplinas().size(); i++) {
                    System.out.println((i + 1) + ". " + alunoBuscado.getDisciplinas().get(i).getNome());
                }
                int opcDisc = menuView.obterInt("Escolha a disciplina (número): ");

                if (opcDisc < 1 || opcDisc > alunoBuscado.getDisciplinas().size()) {
                    menuView.exibirErro("Opção inválida.");
                    break;
                }

                DisciplinaModel discSelecionada = alunoBuscado.getDisciplinas().get(opcDisc - 1);
                try {
                    alunoView.adicionarNotasDisciplina(alunoBuscado, discSelecionada);
                } catch (NotasInsuficientesException e) {
                    menuView.exibirErro(e.getMessage());
                }
                break;
            }

            case 12: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }

                alunoView.exibirDesempenhoAluno(alunoBuscado);
                break;
            }

            case 13: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                List<EstagioModel> estagios = estagCtrl.listarEstagios();
                if (estagios.isEmpty()) {
                    menuView.exibirAviso("Nenhum estágio cadastrado.");
                    break;
                }


                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado = alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }


                estagView.exibirListaEstagios(estagios);
                int opcEstagio = menuView.obterInt("Escolha o estágio (número): ");

                if (opcEstagio < 1 || opcEstagio > estagios.size()) {
                    menuView.exibirErro("Opção inválida.");
                    break;
                }

                EstagioModel estagioSelecionado = estagios.get(opcEstagio - 1);

                if (alunoCtrl.matricularAlunoEmEstagio(alunoBuscado.getMatricula(), estagioSelecionado)) {
                    menuView.exibirSucesso("Aluno matriculado no estágio com sucesso!");
                } else {
                    menuView.exibirErro("Aluno já matriculado neste estágio.");
                }

                break;
            }

            case 14: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();
                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSel = alunoView.obterDadosMatricula(alunos);
                AlunoModel aluno = alunoCtrl.buscarAlunoPorMatricula(alunoSel.getMatricula());

                if (aluno == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }

                try {
                    alunoCtrl.verificarMatriculaEmEstagio(aluno.getMatricula());
                } catch (AlunoNaoMatriculadoEmEstagioException e) {
                    menuView.exibirAviso(e.getMessage());
                    break;
                }

                System.out.println("\nEstágios do aluno:");
                for (int i = 0; i < aluno.getEstagios().size(); i++) {
                    System.out.println((i + 1) + ". " + aluno.getEstagios().get(i).getNome());
                }

                int opc = menuView.obterInt("Escolha o estágio (número): ");
                if (opc < 1 || opc > aluno.getEstagios().size()) {
                    menuView.exibirErro("Opção inválida.");
                    break;
                }

                EstagioModel estagio = aluno.getEstagios().get(opc - 1);

                double media = menuView.obterDouble("Digite a média do estágio (0-100): ");

                if (alunoCtrl.registrarAvaliacaoEstagio(aluno.getMatricula(), estagio, media)) {
                    menuView.exibirSucesso("Avaliação registrada com sucesso!");

                    Double m = estagio.obterMedia(aluno.getMatricula());
                    menuView.exibirAviso("Média: " + m);
                    if (estagio.aprovado(aluno.getMatricula())) {
                        menuView.exibirSucesso("Status: APROVADO");
                    } else {
                        menuView.exibirErro("Status: REPROVADO");
                    }
                } else {
                    menuView.exibirErro("Erro ao registrar avaliação.");
                }

                break;
            }
            case 15: {
                System.out.println("\n=== COMPONENTES ACADÊMICOS ===");

                System.out.println("\nDisciplinas:");
                if (discipCtrl.listarDisciplinas().isEmpty()) {
                    System.out.println("Nenhuma disciplina cadastrada.");
                } else {
                    discipView.exibirListaDisciplinas(discipCtrl.listarDisciplinas());
                }

                System.out.println("\nEstágios:");
                if (estagCtrl.listarEstagios().isEmpty()) {
                    System.out.println("Nenhum estágio cadastrado.");
                } else {
                    estagView.exibirListaEstagios(estagCtrl.listarEstagios());
                }

                break;
            }

            case 16: {
                List<AlunoModel> alunos = alunoCtrl.listarAlunos();

                if (alunos.isEmpty()) {
                    menuView.exibirAviso("Nenhum aluno cadastrado.");
                    break;
                }

                AlunoModel alunoSelecionado = alunoView.obterDadosMatricula(alunos);
                AlunoModel alunoBuscado =
                        alunoCtrl.buscarAlunoPorMatricula(alunoSelecionado.getMatricula());

                if (alunoBuscado == null) {
                    menuView.exibirErro("Aluno não encontrado.");
                    break;
                }

                alunoView.exibirSituacaoAcademica(alunoBuscado);
                break;
            }
                
            default:
                menuView.exibirErro("Opção inválida.");
        }
    }
}
