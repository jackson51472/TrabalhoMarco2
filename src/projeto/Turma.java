package projeto;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private Professor professor;
    private Disciplina disciplina;

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos.add(alunos);
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

                            //===//===//

    public String getNomeProfessor(){

        if (this.professor == null){
            return "Sem Professor cadastrado";
        }
        return professor.getNome();
    }

    public void adicionarAlunoTurma(Aluno... aluno) {
        for (Aluno a : aluno) {
            this.alunos.add(a);
        }
    }

    public List<String> getNomeAlunos(){
        if (this.alunos.isEmpty()){
            throw new NullPointerException("A Turma esta sem alunos");
        }

        List<String> nomes = new ArrayList<>();

        for (int j = 0; j < this.alunos.size(); j++) {
            nomes.add(this.alunos.get(j).getNome());
        }
        return nomes;

    }

    public String getNomeDisciplinas(){
        if (this.disciplina == null){
            return "Sem disciplina";
        }
        if (this.disciplina.getNome() == null){
            return "Sem nome disciplina";
        }
        return this.disciplina.getNome();
    }
}
