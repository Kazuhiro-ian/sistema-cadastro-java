import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        carregarDados(listaPessoas);
        int op = -1;
        //loop de repetição do menu
        do {
            System.out.println("==========Menu do sistema de cadastro==========");
            System.out.println("1. Cadastrar pessoa.");
            System.out.println("2. Listar pessoas.");
            System.out.println("3. Remover pessoa.");
            System.out.println("4. Editar  dados de pessoa.");
            System.out.println("0. Fim.");
            try{
                op = sc.nextInt();
                sc.nextLine();
                //Switch da escolha
                switch (op) {
                    //Cadastro
                    case 1:
                        cadastrarPessoa(sc,  listaPessoas);
                        break;
                    //Listagem
                    case 2:
                        listarPessoas(listaPessoas);
                        break;
                    //Remoção
                    case 3:
                        removerPessoa(listaPessoas, sc);
                        break;
                    //Edição
                    case 4:
                        editarPessoa(listaPessoas, sc);
                        break;
                    case 0:
                        System.out.println("Encerrando sistema e salvando dados");
                        salvarDados(listaPessoas);
                        System.out.println("Dados salvos com sucesso!");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: digite uma opção válida!");
                sc.nextLine();
            }
        } while (op != 0);
        sc.close();
    }

    //Método para cadastro de pessoa
    public  static void cadastrarPessoa(Scanner sc,  ArrayList<Pessoa> listaPessoas) {
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite a idade: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite um email: ");
        String email = sc.nextLine();
        //Criar objeto
        Pessoa p1 = new Pessoa(nome, idade, email);
        //Salvar na lista
        listaPessoas.add(p1);
    }

    //Método para Listagem de pessoas
    public static void listarPessoas(ArrayList<Pessoa> listaPessoas) {
        if(listaPessoas.isEmpty()){
            System.out.println("Ainda não há pessoas cadastradas");
        } else {
            System.out.println("==========Lista de pessoas cadastradas==========");
            for (Pessoa p : listaPessoas) {
                System.out.println(p);
            }
        }
    }

    //Método para remoção de pessoas da lista principal
    public static void removerPessoa(ArrayList<Pessoa> listaPessoas, Scanner sc) {
        if(listaPessoas.isEmpty()) {
            System.out.println("Ainda não há pessoas cadastradas");
        } else {
            System.out.print("Informe o ID da pessoa que deseja remover.");
            for(Pessoa p : listaPessoas) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
            }
            System.out.println("ID: ");
            int escolha = sc.nextInt();
            boolean achou = false;
            //Percorrer lista
            for (Pessoa p : listaPessoas) {
                if (p.getId() == escolha) {
                    listaPessoas.remove(p);
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                System.out.println("Id não encontrado!");
            }
        }
    }

    //Método para edição de dados da classe Pessoa
    public static void editarPessoa(ArrayList<Pessoa> listaPessoas, Scanner sc) {
        if(listaPessoas.isEmpty()) {
            System.out.println("Ainda não há pessoas cadastradas");
        } else {
            System.out.print("Informe o ID da pessoa que deseja editar.");
            for(Pessoa p : listaPessoas) {
                System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
            }
            System.out.println("ID: ");
            int escolha = sc.nextInt();
            sc.nextLine();
            boolean achou = false;
            //Percorrer lista
            for (Pessoa p : listaPessoas) {
                if (p.getId() == escolha) {
                    //Novo nome
                    System.out.println("Digite o novo nome: ");
                    String novoNome = sc.nextLine();
                    p.setNome(novoNome);
                    //Nova idade
                    System.out.println("Digite a nova idade: ");
                    int novaIdade = sc.nextInt();
                    sc.nextLine();
                    p.setIdade(novaIdade);
                    //Novo email
                    System.out.println("Digite o novo email: ");
                    String novoEmail = sc.nextLine();
                    p.setEmail(novoEmail);
                    achou = true;
                    break;
                }
            }
            if(!achou) {
                System.out.println("Id não encontrado!");
            }
        }
    }
    public static void salvarDados(ArrayList<Pessoa> listaPessoas) {
        try {
            FileWriter escritor = new FileWriter("dados.txt");
            for (Pessoa p : listaPessoas) {
                escritor.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
            }
            escritor.close();
        } catch (IOException e) {
            System.out.println("Erro");
        }
    }
    public static void carregarDados (ArrayList<Pessoa> listaPessoas) {
        File arquivo = new File("dados.txt");
        if(!arquivo.exists()) {
            return;
        }
        try {
            Scanner leitorArquivos = new Scanner(arquivo);
            while (leitorArquivos.hasNextLine()) {
                String linha = leitorArquivos.nextLine();

                String[] partes = linha.split(";");

                String nome = partes[0];
                int idade = Integer.parseInt(partes[1]);
                String email = partes[2];

                Pessoa p = new Pessoa(nome, idade, email);
                listaPessoas.add(p);
            }
            leitorArquivos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivos de dados não encontrados!");
        }
    }
}
