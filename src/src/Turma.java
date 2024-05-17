package src;

public class Turma {
    private Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public String getNomeProfessor(){

        if (this.professor == null){
            return "Sem Professor cadastrado";
        }
        return professor.getNome();
    }
}
