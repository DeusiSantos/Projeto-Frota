package funcionarios;

public class Mecanico extends Pessoa{

    private String especialidade;
    private String email;
    private String senha;

    public Mecanico(String nome, String sobrenome, int idade, String especialidade, String email, String senha) {
        super(nome, sobrenome, idade);
        this.especialidade = especialidade;
        this.email = email;
        this.senha = senha;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Mecanico: \n"+super.toString() +"\nespecialidade: " + especialidade + "\nemail: " + email + "\nsenha: " + senha + "";
    }

    
    

    

    

    
}
