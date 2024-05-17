package src.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import src.Professor;
import src.Turma;

class ProfessorTest {
    Professor professor;
    Turma turma;
    @BeforeEach
    void setUp() {
        turma= new Turma();
        professor = new Professor();
    }



}