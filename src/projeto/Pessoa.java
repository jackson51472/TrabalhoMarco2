package projeto;

public class Pessoa {
    private String nome;

    public String getNome() {
        if (this.nome == null){
            return "Nome NULO";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
