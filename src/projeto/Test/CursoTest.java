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
        Turma turma1 = new Turma();
        Turma turma2 = new Turma();
        Professor p1 = new Professor();

        professor.setNome("Marco");

        turma2.setProfessor(p1);
        turma.setProfessor(professor);

        curso.adicionarTurma(turma, turma1, turma2);

        List<String> nomesEsperados = List.of("Marco", "Sem Professor cadastrado", "Nome NULO");

        assertEquals(nomesEsperados, curso.getNomeProfessor());
    }

    // 4
    @Test
    void deveRetornarNomeAlunosTurma() {
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");
        Turma t2 = new Turma();

        turma.adicionarAlunoTurma(a1,a2);
        t2.adicionarAlunoTurma(aluno,a1);

        curso.adicionarTurma(turma,t2);

        List<String> nomesEsperados = List.of("Teste", "Barco", "Marco", "Teste");
        assertEquals(nomesEsperados, curso.getNomeAlunosTurma());
        }

    @Test
    void deveRetornarCursoSemTurma2() {
        try {
            curso.getNomeAlunosTurma();
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
        Disciplina d2 = new Disciplina();
        Turma t2 = new Turma();
        Turma t3 = new Turma();

        disciplina.setNome("Calculo I");

        turma.setDisciplina(disciplina);
        t3.setDisciplina(d2);

        curso.adicionarTurma(turma,t2,t3);

        List<String> nomesEsperados = List.of("Calculo I", "Sem disciplina", "Sem nome disciplina");

        assertEquals(nomesEsperados, curso.getNomeDisciplinas());
    }

    //8
    @Test
    void deveRetornarAlunoExpecifico(){
        Aluno a1 = new Aluno("Marco");

        aluno.setNome("Teste");

        curso.adicionarAluno(aluno,a1);

        Assertions.assertEquals(a1, curso.getAlunoEspecifico(a1));

    }
    @Test
    void deveRetornarTurmaSemAluno(){
        Assertions.assertEquals("Sem alunos na Turma", curso.getAlunoEspecifico(aluno));
    }

    // 9
    @Test
    void deveRetornarTurmaExpecifico(){
        Turma t1 = new Turma();
        curso.adicionarTurma(turma,t1);
        Assertions.assertEquals(t1, curso.getTurmaExpecifica(t1));

    }
    @Test
    void deveRetornarCursoSemTurma3(){
        Assertions.assertEquals("Sem Turma no Curso", curso.getTurmaExpecifica(turma));
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
        List<String> nomesEsperados = List.of("3°", "4°");

        Assertions.assertEquals(nomesEsperados, curso.deleteTurmaCurso(turma));

    }
    @Test
    void deveRetornarCursoSemTurma1(){
        Assertions.assertEquals("Sem Turma no Curso", curso.deleteTurmaCurso(turma));
    }

    //12
    @Test
    void deveRetornarAlunoRemovido(){
        Aluno a1 = new Aluno("Teste");
        Aluno a2 = new Aluno("Barco");

        curso.adicionarAluno(a1,a2,aluno);

        List<String> nomesEsperados = List.of("Teste", "Barco");

        Assertions.assertEquals(nomesEsperados, curso.deleteAlunoCurso(aluno));

    }
    @Test
    void deveRetornarTurmaSemAluno2(){
        Assertions.assertEquals("Sem alunos no Curso", curso.deleteAlunoCurso(aluno));
    }
}