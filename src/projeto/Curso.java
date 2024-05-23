package projeto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Curso {
    private List<Turma> turmas;
    private ArrayList<Aluno> alunos;

    public Curso() {
        this.alunos = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public List<Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }


                        //===//===//

    public Object getNomeProfessor(){


        List<String> listaProfessores= new ArrayList<String>();

        for (Turma j : this.turmas) {

            listaProfessores.add(j.getNomeProfessor());

        }

        return listaProfessores;
    }

    public void adicionarTurma(Turma... turmas) {
        for (Turma t : turmas) {
            this.turmas.add(t);
        }
    }

    public void adicionarAluno(Aluno... aluno) {
        for (Aluno a : aluno) {
            this.alunos.add(a);
        }
    }

    public List<String> getNomeAlunosTurma(){

        if (this.turmas.isEmpty()){
            throw new NullPointerException("Curso não tem turma");
        }
        List<String> listaAlunos = new ArrayList<String>();

        for (Turma j : this.turmas) {

            listaAlunos.addAll(j.getNomeAlunos());
        }
        return listaAlunos;
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

    public List<String> getNomeDisciplinas(){
        if (this.turmas.isEmpty()){
            throw new NullPointerException("Curso sem Aluno");
        }
        List<String> listaDiciplinas = new ArrayList<>();
        for (Turma t : this.turmas) {

            listaDiciplinas.add(t.getNomeDisciplinas());

        }
        return listaDiciplinas;
    }

    public Object getAlunoEspecifico(Aluno aluno){
        if (this.alunos.isEmpty()){
            return "Sem alunos na Turma";
        }
        for (Aluno a : this.alunos) {

            if ( a.equals(aluno)){
                return a;
            }
        }
        return null;
    }

    public Object getTurmaExpecifica(Turma turma){
        if (this.turmas.isEmpty()){
            return "Sem Turma no Curso";
        }

        for (Turma t : this.turmas) {
            if ( t.equals(turma)){
                return t;
            }
        }

        return null;
    }

    public Object deleteAlunoCurso(Aluno aluno){
        if (alunos.isEmpty()){
            return "Sem alunos no Curso";
        }

        this.alunos.remove(aluno);
        List<String> listaAtualizada = new ArrayList<>();

        for (Aluno j : this.alunos) {
            listaAtualizada.add(j.getNome());
        }
        return listaAtualizada;

    }

    public Object deleteTurmaCurso(Turma turma){
        if (this.turmas.isEmpty()){
            return "Sem Turma no Curso";
        }
        this.turmas.remove(turma);

        List<String> listaAtualizada = new ArrayList<>();

        for (Turma j : this.turmas) {
            listaAtualizada.add(j.getPeriodo());
        }
        return listaAtualizada;



    }
}

