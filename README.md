# Princípios SOLID em Java ☕

## 📝 Sobre o Projeto

Este repositório é um guia prático e focado na demonstração dos 5 **Princípios SOLID** da Programação Orientada a Objetos, implementados na linguagem Java.

O objetivo é ilustrar, através de exemplos claros de "o que não fazer" (código acoplado) e "o que fazer" (código refatorado), como aplicar essas regras para criar softwares altamente coesos, com baixo acoplamento, flexíveis a mudanças e fáceis de manter a longo prazo.

## 💡 Principais Conceitos Abordados

* **S - Single Responsibility Principle (SRP):** Demonstração de que uma classe deve ter apenas uma única responsabilidade e um único motivo para mudar, separando lógicas de regras de negócio, persistência e apresentação.
* **O - Open/Closed Principle (OCP):** Como projetar entidades (classes, módulos, funções) que estejam abertas para extensão (adição de novos comportamentos), mas fechadas para modificação (alteração do código fonte existente), utilizando polimorfismo e interfaces.
* **L - Liskov Substitution Principle (LSP):** Exemplos práticos garantindo que classes derivadas (subclasses) possam substituir suas classes base (superclasses) sem quebrar o comportamento ou a integridade do sistema.
* **I - Interface Segregation Principle (ISP):** A importância de criar interfaces pequenas e específicas para cada cliente, evitando que classes sejam forçadas a implementar métodos que não utilizam.
* **D - Dependency Inversion Principle (DIP):** Como desacoplar módulos de alto nível de módulos de baixo nível, fazendo com que ambos dependam de abstrações (interfaces) e não de implementações concretas, facilitando a Injeção de Dependências.

## 🛠️ Tecnologias Utilizadas

* Java (versão 17 ou superior recomendada)
* Maven (gerenciador de dependências e build)

---

## 🚀 Como Executar o Projeto

Você pode explorar e rodar os exemplos deste projeto tanto diretamente pelo terminal quanto utilizando o ambiente da sua IDE.

### 📋 Pré-requisitos

Certifique-se de ter em sua máquina:

* **Java JDK** (versão 17 ou superior) configurado nas variáveis de ambiente (`JAVA_HOME`).
* **Apache Maven** instalado (ou utilize o Maven Wrapper `./mvnw` incluso no projeto).

### 💻 Opção 1: Executando pelo Terminal (Sem IDE)

Para compilar o código e visualizar o comportamento das classes isoladas pelo terminal:

1. **Clone o repositório:**
```bash
git clone https://github.com/joaoalbertorsc/solid-principles.git
cd solid-principles

```


2. **Compile o projeto:**
Execute o Maven para baixar possíveis dependências e garantir que o projeto compile corretamente:
```bash
mvn clean compile

```


3. **Execute a aplicação:**
* Se o plugin do Maven já estiver configurado com a classe principal no `pom.xml`:
```bash
mvn exec:java

```


* Caso prefira rodar informando o caminho completo da classe principal (substitua pelo pacote e classe do princípio que deseja testar):
```bash
mvn exec:java -Dexec.mainClass="com.seuprojeto.Main"

```




4. **Execute os Testes Unitários:**
Se houver testes para validar a integridade das regras do SOLID:
```bash
mvn test

```



### 🖥️ Opção 2: Executando via IDE (IntelliJ IDEA, Eclipse, VS Code)

Para uma experiência visual completa e facilitar a navegação entre as abstrações e implementações:

1. **Importar o Projeto:**
* Abra a sua IDE.
* Vá em **Open** ou **Import Project**.
* Navegue até a pasta clonada e selecione o arquivo `pom.xml`.


2. **Navegar e Executar:**
* O projeto costuma ser dividido em pacotes por princípios (ex: `srp`, `ocp`, `lsp`, etc.). Entre em cada pacote, localize a respectiva classe `Main` ou de teste.
* Clique com o botão direito e selecione **Run**.


3. **Explorar a Arquitetura:**
* Utilize atalhos da sua IDE (como `Ctrl + Click` ou `F4`) para navegar rapidamente das interfaces (abstrações) para as classes concretas, compreendendo como o princípio da Inversão de Dependência e a Segregação de Interfaces afetam a estrutura do código.



---

## 👨‍💻 Autor

**João Alberto** – Engenheiro de Software

---

*Se este guia te ajudou a compreender melhor como aplicar SOLID em seus projetos Java, deixe uma ⭐ no repositório!*
