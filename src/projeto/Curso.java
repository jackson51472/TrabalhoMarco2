package projeto;

public class Curso {
    private Turma turma;

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getNomeProfessor(){
        if (this.turma == null){
            return "Curso sem Turma";
        }
        return turma.getNomeProfessor();
    }
}
