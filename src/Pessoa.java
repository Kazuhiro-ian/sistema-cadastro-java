public class Pessoa {
    // Atributos da pesssoa
    private String nome;
    private int idade;
    private String email;
    private static int contador = 1;
    private int id;

    // Construtor
    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.id = contador++;
    }

    // Getters e Setters
    //Id
    public int getId() {
        return  id;
    }
    //Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Idade
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Email: " + email;
    }
}
