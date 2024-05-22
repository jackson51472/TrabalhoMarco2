package projeto.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import projeto.Aluno;
import projeto.Professor;
import projeto.Turma;

import java.util.List;

class TurmaTest {
    Professor professor;
    Turma turma;
    Aluno aluno;


    @BeforeEach
    void setUp() {
        aluno = new Aluno("Marco");
        turma= new Turma();
        professor = new Professor();
    }

    // 1
    @Test
    void deveRetornarNomeProfessor(){

        professor.setNome("Marco");
        turma.setProfessor(professor);

        Assertions.assertEquals("Marco", turma.getNomeProfessor());
    }
    @Test
    void deveRetornarProfessorSemNome(){
        turma.setProfessor(professor);

        Assertions.assertEquals("Nome NULO", turma.getNomeProfessor());
    }
    @Test
    void deveRetornarSemProfessor(){
        Assertions.assertEquals("Sem Professor cadastrado", turma.getNomeProfessor());
    }

    //2
    @Test
    void deveRetornarNomesAlunos(){
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        turma.adicionarAlunoTurma(a1,a2,aluno);

        List<String> nomesEsperados = List.of("Teste", "Barco", "Marco");

        Assertions.assertEquals(nomesEsperados, turma.getNomeAlunos());
    }
    @Test
    void deveRetornarSemAlunos(){
        try {
            turma.getNomeAlunos();
        }catch (NullPointerException e){
            Assertions.assertEquals("A Turma esta sem alunos",e.getMessage());
        }
    }

    //7
    @Test
    void deveRetornarAlunoExpecifico(){
        Aluno a1 = new Aluno("Marco");
        aluno.setNome("Teste");
        turma.adicionarAlunoTurma(aluno,a1);
        Assertions.assertEquals("Teste", turma.getNomeExpecifico("Teste"));

    }
    @Test
    void deveRetornarAlunoNaoEncontrado(){
        aluno.setNome("Teste");
        turma.adicionarAlunoTurma(aluno);
        Assertions.assertEquals("Nome não encontrado", turma.getNomeExpecifico("Errado"));

    }
    @Test
    void deveRetornarTurmaSemAluno(){
        Assertions.assertEquals("Sem alunos na Turma", turma.getNomeExpecifico("Teste"));
    }

    //10
    @Test
    void deveRetornarAlunoRemovido(){
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        turma.adicionarAlunoTurma(a1,a2,aluno);

        List<String> nomesEsperados = List.of("Teste", "Barco");

        Assertions.assertEquals(nomesEsperados, turma.deleteAlunoTurma("Marco"));

    }
    @Test
    void deveRetornarAlunoNaoEncontrado2(){
        aluno.setNome("Teste");
        turma.adicionarAlunoTurma(aluno);
        Assertions.assertEquals("Nome não encontrado", turma.deleteAlunoTurma("Errado"));

    }
    @Test
    void deveRetornarTurmaSemAluno2(){
        Assertions.assertEquals("Sem alunos na Turma", turma.deleteAlunoTurma("Teste"));
    }
}