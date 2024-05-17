package projeto.Test;

import org.junit.jupiter.api.BeforeEach;
import projeto.Professor;
import projeto.Turma;

class ProfessorTest {
    Professor professor;
    Turma turma;
    @BeforeEach
    void setUp() {
        turma= new Turma();
        professor = new Professor();
    }



}