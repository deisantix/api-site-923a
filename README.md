# API do Site da 923a (Desenvolvimento de Sistemas)
<p align="center">
  <img src="https://user-images.githubusercontent.com/87045182/184548602-2caa4960-0aab-4a43-937b-fc7b5a9b7161.png" alt="Logo do 3° ano do curso de Desenvolvimento de Sistemas" style="width: 100px">
</p>

![Versão do OpenJDK](https://img.shields.io/badge/open--jdk-v11.0.16-red) ![Versão do Spring Boot](https://img.shields.io/badge/spring--boot-v2.7.2-brightgreen) ![Banco de Dados usado](https://img.shields.io/badge/database-mongodb-green)

## Índices

* [Descrição](#descrição)
* [Funcionalidades](#funcionalidades)
* [Banco de Dados](#banco-de-dados)
* [Hosting](#hosting)
* [Técnicas e tecnologias utilizadas](#técnicas-e-tecnologias-utilizadas)

## Descrição

Um REST Web Service feito em Java usando o framework Spring com o intuito de dinamizar e persistir os dados do site da turma 923A, do curso de Desenvolvimento de Sistemas do IFAL (Campus Maceió).

No momento, é utilizado apenas para manipular as atividades da turma, tendo um CRUD (Create, Read, Update, Delete) quase completo para essa manipulação.

##### :warning: Esse README não possui tópicos como "Acesso ao projeto" ou "Como usar" pois não promovo a utilização dessa API por outras pessoas. Esse projeto foi desenvolvido EXCLUSIVAMENTE para o site da turma 923A (que pode ser acessado nesse link: https://github.com/deisantix/site-923a). Outras pessoas utilizarem das funcionalidades dessa API em específico (principalmente a que está no ar) poderia resultar em inconsistências e atrapalhar seu objetivo.

## Funcionalidades

- Func. 1: A aplicação permite a coletânia das atividades armazenadas no banco de dados por meio de um _end-point_ específico (GET)
- Func. 2: Usando da mesma _end-point_, porém passando um documento `JSON` no _body_ do _request_, é possível adicionar novas atividades ao banco de dados (POST)
  - Func. 2.1: Há parâmetros indispensáveis no momento de cadastrar uma nova atividade. Caso não haja as informações necessárias (ou seja, vazias), o programa acusará erro
  - Func. 2.2: O parâmetro que disponibiliza o link da atividade no Google Classroom é opcional, então pode ser ocultado no request
  - Func. 2.3: A aplicação também verifica se as informações estão sendo passadas corretamente, pois, internamente, essas informações são transformadas em objetos do Java, que acusam erro caso sejam inválidos
- Func. 3: É possível deletar as atividades do banco de dados usando de um _end-point_ específico dado o ID da atividade no _body_ do _request_ (DELETE)
- Func. 4: O CORS (Compartilhamento de Recursos de Origem Cruzada) da aplicação permite apenas o compartilhamento de dados entre o site da 923a hospedado no Vercel (https://desenv-sistemas-923a.vercel.app/) e o `localhost` (caso o site esteja sendo testado localmente), o que signifca que qualquer outro serviço buscando essas informações deveria ser bloqueado

## Banco de Dados

Para armazenar as informações das atividades da turma foi utilizado o Banco de Dados Não-Relacional MongoDB, baseado em documentos, além de que foi usado sua versão para Web (MongoDB Atlas) que dispõe _clusters_ em Clouds, perfeito para o desenvolvedor que não tem tempo para (ou não sabe) admnistrar toda a infraestrutura necessária para o MongoDB localmente.

Link: https://www.mongodb.com/

## Hosting

Outro serviço foi utilizado para manter a aplicação no ar, e nesse caso foi Heroku.

Heroku é uma plataforma em Cloud baseada em conteiners usada para o _deployment_ de aplicações modernas. Seus serviços suportam diversas linguagens de programação, inclusive Java. 

Graças a Heroku, a API do Site da 923a pode ficar constantemente no ar, permitindo assim que os request sejam feitas a qualquer momento.

Link: https://id.heroku.com/login

## Técnicas e tecnologias utilizadas:

Para o desenvolvimento desse Web Service foi utilizado o editor de código VSCode. A linguagem utilizada foi Java, com auxílio do framework Spring, e consequentemente utilizando o paradigma de Orientação a Objetos. MongoDB Atlas foi usado para o uso do Banco de Dados MongoDB, e Heroku utilizado para o _deploy_ da aplicação.


