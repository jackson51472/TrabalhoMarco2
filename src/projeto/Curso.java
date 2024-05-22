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

    public String getNomeExpecifico(String nome){
        if (this.alunos.isEmpty()){
            return "Sem alunos na Turma";
        }
        for (Aluno a : this.alunos) {
            if (a.getNome().intern().equals(nome))
                return a.getNome();
        }
        return  "Nome não encontrado";
    }
    public String getTurmaExpecifica(String turma){
        if (this.turma.isEmpty()){
            return "Curso sem Turma";
        }
        for (Turma t : this.turma) {
            if (t.getPeriodo().intern().equals(turma))
                return t.getPeriodo();
        }
        return  "Turma não encontrado";
    }
    public Object deleteAlunoCurso(String nome){
        if (alunos.isEmpty()){
            return "Sem alunos no Curso";
        }
        for (Aluno a : this.alunos) {
            if (a.getNome().intern().equals(nome)){
                alunos.remove(a);
                List<String> listaAtualizada = new ArrayList<>();

                for (Aluno j : this.alunos) {
                    listaAtualizada.add(j.getNome());
                }
                return listaAtualizada;

            }
        }
        return  "Nome não encontrado";
    }
    public Object deleteTurmaCurso(String nome){
        if (turma.isEmpty()){
            return "Sem Turma no Curso";
        }
        for (Turma t : this.turma) {
            if (t.getPeriodo().intern().equals(nome)){
                turma.remove(t);
                List<String> listaAtualizada = new ArrayList<>();

                for (Turma j : this.turma) {
                    listaAtualizada.add(j.getPeriodo());
                }
                return listaAtualizada;

            }
        }
        return  "Turma não encontrado";
    }
}

