[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10075000)
# Gestão de Estoque
Uma mercearia está informatizando seus processos e vai começar a modernização pela gestão de estoque. O nosso objetivo é atender a eses requisitos do cliente, enquanto criamos e documentamos essa aplicação.

---

## Nota base do grupo: 5,1 

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários

- classpath referenciando [arquivo local "Users/xxxx/Download..."](./erroJar.PNG) impede qualquer coisa de rodar.

### Diagrama + aderência das classes ao diagrama: 1,6/2 pontos 
	- relacionamento entre as classes?
    - checaEstoqueMinimo tem 2 parâmetros no código do Produto.
### Requisitos corretamente implementados: 2/6 pontos 
	- produto (preço, estoque)
        - entrada e saída, preco custo, estoque: sem validação de quantidade.
        - diversos get privados que apenas usam a variável... precisa?
        - sem conseguir rodar nem testar, não vi onde está o cálculo do preço de venda.
	- estoque (valor, abaixo do estoque)
        - "checaEstoqueMinimo" chamado sem parâmetros não existe: não executa.
        - vários gets usados nos streams estão privados no produto: não executa.
        - print dentro de classe
	- sistema (vender, comprar, consultas)
        - usa um construtor de produto sem id. O teste usa com id. Se um funciona, o outro não funciona.

    - observações sem desconto de ponto
        - Por que não usar um arquivo com os produtos para iniciar o main? Muito melhor um loop no arquivo do que NOVE variáveis produto manuais.
        - Exceções mal utilizadas: RuntimeException é muito genérica. 

### Documentação de código: 1,5/3 pontos 
    - parcial no Produto e pouco informativa no Estoque.
	
	
### Testes (quantidade e qualidade): 0/4 pontos 
    - classpath referenciando arquivo local "Users/xxxx/Download..." impede teste de rodar.
    - testes de produto e estoque chamando construtor não existente de Produto.
	- produto: 0/2 pontos
	- estoque: 0/2 pontos

---

## Alunos integrantes da equipe

* Vitor Lany Freitas Ferreira
* Augusto Baldiotti Mendonça Alvares 
* Daniel de Rezende Leão
* Caio Elias Rodrigues Araujo 

## Professor responsável

* João Caram Santos de Oliveira
