package projeto.Test;

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
}