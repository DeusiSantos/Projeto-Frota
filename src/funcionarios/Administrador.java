package funcionarios;

public class Administrador extends Pessoa{
    private String email;
    private String senha;
    
    public Administrador(String nome, String sobrenome, int idade , String emai, String senha) {
        super(nome, sobrenome, idade);
        this.email = emai;
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
        return "Administrador:\n"+ super.toString() + "\n email:"+ email + "\n senha:" + senha;
    }

}
