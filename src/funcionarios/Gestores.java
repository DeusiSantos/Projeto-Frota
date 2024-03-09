package funcionarios;

public class Gestores extends Pessoa {
    private String email;
    private String senha;

    public Gestores(String nome, String sobrenome, int idade , String email , String senha) {
        super(nome, sobrenome, idade);
        this.email = email;
        this.senha = senha;
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
        return "Gestor: \n"+ super.toString() + "\n email:"+ email + "\n senha:" + senha;
    }


    
    
}
