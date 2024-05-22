package projeto.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import projeto.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class CursoTest {
    Disciplina disciplina;
    Professor professor;
    Turma turma;
    Curso curso;
    Aluno aluno;
    @BeforeEach
    void setUp() {
        disciplina  = new Disciplina();
        aluno = new Aluno("Marco");
        curso = new Curso();
        turma= new Turma();
        professor = new Professor();
    }

    // 3
    @Test
    void deveRetornarNomeProfessorTurma(){
        curso.adicionarTurma(turma);
        turma.setProfessor(professor);
        professor.setNome("Marco");
        assertEquals("Marco", curso.getNomeProfessor(0));
    }
    @Test
    void deveRetornarSemNomeProfessor(){
        curso.adicionarTurma(turma);
        turma.setProfessor(professor);
        assertEquals("Nome NULO", curso.getNomeProfessor(0));
    }
    @Test
    void deveRetornarTurmaSemProfessor(){
        curso.adicionarTurma(turma);
        assertEquals("Sem Professor cadastrado", curso.getNomeProfessor(0));
    }
    @Test
    void deveRetornarCursoSemTurma(){
        try {
            curso.getNomeProfessor(0);
        }catch (NullPointerException e){
            assertEquals("Curso não tem turma",e.getMessage());

        }
    }

    // 4
    @Test
    void deveRetornarNomeAlunosTurma() {
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        turma.adicionarAlunoTurma(a1,a2,aluno);

        curso.adicionarTurma(turma);

        List<String> nomesEsperados = List.of("Teste", "Barco", "Marco");
        assertEquals(nomesEsperados, curso.getNomeAlunosTurma(0));
        }
    @Test
    void deveRetornarTurmaCursoSemAlunos() {
        curso.adicionarTurma(turma);
        try {
            curso.getNomeAlunosTurma(0);
            fail("DEU MERDA, \nEra par ter retornado que a Turma tava sem aluno");
        }catch (NullPointerException e) {
            assertEquals("A Turma esta sem alunos", e.getMessage());
        }
    }

    @Test
    void deveRetornarCursoSemTurma2() {
        try {
            curso.getNomeAlunosTurma(0);
            fail("DEU MERDA, \nEra par ter retornado que o curso tava sem turma");
        }catch (NullPointerException e) {
            assertEquals("Curso não tem turma", e.getMessage());
        }
    }

    //5
    @Test
    void deveRetornarNomeAluno() {
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        curso.adicionarAluno(a1,a2,aluno);

        List<String> nomesEsperados = List.of("Teste", "Barco", "Marco");

        assertEquals(nomesEsperados, curso.getNomeAlunos());

    }
    @Test
    void deveRetornarSemAluno() {
        try {

            curso.getNomeAlunos();

        }catch (NullPointerException e){

            assertEquals("Curso sem Aluno", e.getMessage());

        }

    }

    //6
    @Test
    void deveRetornarNomeDisciplina() {
        disciplina.setNome("Calculo");
        turma.setDisciplina(disciplina);
        curso.adicionarTurma(turma);

        assertEquals("Calculo",curso.getNomeDisciplinas(0));
    }
    @Test
    void deveRetornarSemNomeDisciplina() {
        turma.setDisciplina(disciplina);
        curso.adicionarTurma(turma);

        assertEquals("Sem nome disciplina",curso.getNomeDisciplinas(0));
    }
    @Test
    void deveRetornarSemDisciplina() {
        curso.adicionarTurma(turma);

        assertEquals("Sem disciplina",curso.getNomeDisciplinas(0));
    }
    @Test
    void deveRetornarSemTurma() {
        assertEquals("Turma não encontrada",curso.getNomeDisciplinas(0));
    }

    //8
    @Test
    void deveRetornarAlunoExpecifico(){
        Aluno a1 = new Aluno("Marco");
        aluno.setNome("Teste");
        curso.adicionarAluno(aluno,a1);
        Assertions.assertEquals("Teste", curso.getNomeExpecifico("Teste"));

    }
    @Test
    void deveRetornarAlunoNaoEncontrado(){
        aluno.setNome("Teste");
        curso.adicionarAluno(aluno);
        Assertions.assertEquals("Nome não encontrado", curso.getNomeExpecifico("Errado"));

    }
    @Test
    void deveRetornarTurmaSemAluno(){
        Assertions.assertEquals("Sem alunos na Turma", curso.getNomeExpecifico("Teste"));
    }

    // 9
    @Test
    void deveRetornarTurmaExpecifico(){
        Turma t1 = new Turma();
        t1.setPeriodo("Teste");
        turma.setPeriodo("5°");
        curso.adicionarTurma(turma,t1);
        Assertions.assertEquals("Teste", curso.getTurmaExpecifica("Teste"));

    }
    @Test
    void deveRetornarTurmaNaoEncontrado(){
        turma.setPeriodo("5°");
        curso.adicionarTurma(turma);
        Assertions.assertEquals("Turma não encontrado", curso.getTurmaExpecifica("Errado"));

    }
    @Test
    void deveRetornarCursoSemTurma3(){
        Assertions.assertEquals("Curso sem Turma", curso.getTurmaExpecifica("Teste"));
    }

    //11
    @Test
    void deveRetornarTurmaRemovido(){
        Turma t1 = new Turma();
        Turma t2 = new Turma();
        t1.setPeriodo("3°");
        t2.setPeriodo("4°");
        turma.setPeriodo("5° Deleta minha turma kkk");

        curso.adicionarTurma(t1,t2,turma);
        List<String> nomesEsperados = List.of("3°", "4°");  //"6°", "7°"

        Assertions.assertEquals(nomesEsperados, curso.deleteTurmaCurso("5° Deleta minha turma kkk"));

    }
    @Test
    void deveRetornarTurmaNaoEncontrado1(){
        turma.setPeriodo("5°");
        curso.adicionarTurma(turma);

        Assertions.assertEquals("Turma não encontrado", curso.deleteTurmaCurso("Errado"));

    }
    @Test
    void deveRetornarCursoSemTurma1(){
        Assertions.assertEquals("Sem Turma no Curso", curso.deleteTurmaCurso("Teste"));
    }

    //12
    @Test
    void deveRetornarAlunoRemovido(){
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        curso.adicionarAluno(a1,a2,aluno);

        List<String> nomesEsperados = List.of("Teste", "Barco");

        Assertions.assertEquals(nomesEsperados, curso.deleteAlunoCurso("Marco"));

    }
    @Test
    void deveRetornarAlunoNaoEncontrado2(){
        curso.adicionarAluno(aluno);
        Assertions.assertEquals("Nome não encontrado", curso.deleteAlunoCurso("Errado"));

    }
    @Test
    void deveRetornarTurmaSemAluno2(){
        Assertions.assertEquals("Sem alunos no Curso", curso.deleteAlunoCurso("Teste"));
    }
}