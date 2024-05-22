package projeto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Curso {
    private List<Turma> turma;
    private ArrayList<Aluno> alunos;

    public Curso() {
        this.alunos = new ArrayList<>();
        this.turma = new ArrayList<>();
    }

    public List<Turma> getTurma() {
        return turma;
    }
    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getNomeProfessor(Integer t){
        if (this.turma.isEmpty()){
            throw new NullPointerException("Curso não tem turma");
        }
        return turma.get(t).getNomeProfessor();
    }

    public void adicionarTurma(Turma... turmas) {
        for (Turma t : turmas) {
            this.turma.add(t);
        }
    }

    public void adicionarAluno(Aluno... aluno) {
        for (Aluno a : aluno) {
            this.alunos.add(a);
        }
    }

    public List<String> getNomeAlunosTurma(Integer t){

        if (this.turma.isEmpty()){
            throw new NullPointerException("Curso não tem turma");
        }

        return this.turma.get(t).getNomeAlunos();
    }

    public List<String> getNomeAlunos(){
        if (this.alunos.isEmpty()){
            throw new NullPointerException("Curso sem Aluno");
        }
        List<String> nomes = new ArrayList<>();
        for (int j = 0; j < this.alunos.size(); j++) {

            nomes.add(this.alunos.get(j).getNome());

        }
        return nomes;
    }

    public String getNomeDisciplinas(Integer i){
        if (i >= this.turma.size()){
            return "Turma não encontrada";
        }
        return turma.get(i).getNomeDisciplinas();
    }
}
