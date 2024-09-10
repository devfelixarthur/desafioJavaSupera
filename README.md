# Desafio Técnico - Supera Tecnologia

Este repositório contém a implementação dos desafios 1 e 3 apresentados no PDF enviado. O objetivo é realizar operações com resistores (Desafio 1) e percorrer uma matriz em ordem caracol (Desafio 3).

## Índice

- [Desafio 1: Conversor de Resistores](#desafio-1-conversor-de-resistores)
- [Desafio 3: Ordem Caracol em Matriz](#desafio-3-ordem-caracol-em-matriz)
- [Configuração do Projeto](#configuração-do-projeto)
- [Execução do Projeto](#execução-do-projeto)
- [Contato](#contato)

## Desafio 1: Conversor de Resistores

O Desafio 1 implementa um conversor que recebe um valor de resistência em ohms e retorna as cores do código do resistor correspondentes. O usuário pode inserir valores como `47 ohms`, `4.7k ohms`, `1M ohms` e assim por diante, e o sistema retorna as cores do resistor de acordo com a norma.

### Exemplo de Uso

- **Entrada:** `47 ohms`
- **Saída:** `Amarelo, Violeta, Preto, Dourado`

## Desafio 3: Ordem Caracol em Matriz

O Desafio 3 percorre uma matriz bidimensional em formato de caracol, retornando os valores na ordem em que são percorridos.

### Exemplo de Uso

- **Entrada:** Matriz 3x3


- **Saída:** `[1, 2, 3, 6, 9, 8, 7, 4, 5]`

## Configuração do Projeto

Siga os passos abaixo para configurar e rodar o projeto na sua máquina local:

### 1. Clone o repositório

Primeiro, clone o repositório em sua máquina local usando o comando abaixo:

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

### 2. Acesse o diretório do projeto

```bash
cd nome-do-repositorio
```

### 3. Instale as dependências do projeto

Certifique-se de que você tenha o Maven ou qualquer outra ferramenta de gerenciamento de dependências compatível com o Spring Boot instalado. Rode o comando para baixar as dependências:

```bash
mvn clean install
```

### 4. . Execute a aplicação

Após as dependências serem instaladas e o ambiente estar configurado, inicie o servidor localmente:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em http://localhost:8080.

