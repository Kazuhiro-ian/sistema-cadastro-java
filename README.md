# 📋 Sistema de Cadastro de Pessoas (CRUD) em Java

Um sistema de gerenciamento de cadastros completo desenvolvido em Java puro. Este projeto aplica os conceitos fundamentais de Orientação a Objetos e manipulação de arquivos, permitindo a persistência de dados no disco local.

## 🚀 Funcionalidades

O sistema opera com um menu interativo no terminal (Console) e oferece as seguintes operações (CRUD):
* **C**reate: Cadastro de novas pessoas (Nome, Idade e Email).
* **R**ead: Listagem de todas as pessoas cadastradas.
* **U**pdate: Edição completa dos dados de um usuário existente buscando pelo ID.
* **D**elete: Remoção de usuários específicos da base de dados.
* **💾 Persistência de Dados:** Salvamento automático da lista em um arquivo `.txt` ao encerrar o sistema, e carregamento automático ao iniciar.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java
* **Estruturas de Dados:** `ArrayList` para manipulação em memória.
* **Entrada e Saída (I/O):** `Scanner` para leitura do teclado e arquivos.
* **Manipulação de Arquivos:** `FileWriter`, `File` e `FileNotFoundException` para gravar e ler o arquivo `dados.txt`.
* **Tratamento de Exceções:** Uso de `try-catch` para evitar quebras de sistema (ex: `InputMismatchException` para validação de menu).
* **Boas Práticas:** Separação de responsabilidades em métodos dedicados, mantendo o método `main` limpo.

## 💻 Como executar o projeto

1. Clone este repositório em sua máquina local:
   `git clone https://github.com/Kazuhiro-ian/sistema-cadastro-java.git`
2. Abra o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3. Execute o arquivo `Main.java`.
4. Navegue pelas opções do menu digitando os números correspondentes.

---
Desenvolvido com dedicação por **Ian Kazuhiro** 👨‍💻
