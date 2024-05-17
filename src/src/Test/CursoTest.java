package src.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Curso;
import src.Professor;
import src.Turma;

import static org.junit.jupiter.api.Assertions.*;

class CursoTest {
    Professor professor;
    Turma turma;
    Curso curso;
    @BeforeEach
    void setUp() {
        curso = new Curso();
        turma= new Turma();
        professor = new Professor();
    }

    // 3
    @Test
    void deveRetornarNomeProfessorTurma(){
        curso.setTurma(turma);
        turma.setProfessor(professor);
        professor.setNome("Marco");
        assertEquals("Marco", curso.getNomeProfessor());
    }
    @Test
    void deveRetornarSemNomeProfessor(){
        curso.setTurma(turma);
        turma.setProfessor(professor);
        assertEquals("Nome NULO", curso.getNomeProfessor());
    }
    @Test
    void deveRetornarTurmaSemProfessor(){
        curso.setTurma(turma);
        assertEquals("Sem Professor cadastrado", curso.getNomeProfessor());
    }
    @Test
    void deveRetornarCursoSemTurma(){
        assertEquals("Curso sem Turma", curso.getNomeProfessor());
    }

}