package projeto;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;
    private Professor professor;
    private Disciplina disciplina;
    private String periodo;

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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

                            //===//===//

    public Object getNomeEspecifico(Aluno aluno){
        if (alunos.isEmpty()){
            return "Sem alunos na Turma";
        }
        for (Aluno a : this.alunos) {

            if ( a.equals(aluno)){
                return a;
            }
        }
        return  null;
    }

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

    public Object deleteAlunoTurma(Aluno aluno) {
        if (alunos.isEmpty()) {
            return "Sem alunos na Turma";
        }
        alunos.remove(aluno);

        List<String> listaAtualizada = new ArrayList<String>();

        for (Aluno j : this.alunos) {

            listaAtualizada.add(j.getNome());

        }
        return listaAtualizada;
    }
}



