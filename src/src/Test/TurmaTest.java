package src.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import src.Professor;
import src.Turma;

import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {
    Professor professor;
    Turma turma;
    @BeforeEach
    void setUp() {
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

}