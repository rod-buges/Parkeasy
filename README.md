Parkeasy 🚗🅿️
Parkeasy é uma aplicação web que facilita a busca e reserva de estacionamentos de maneira simples e eficiente. Desenvolvida com o objetivo de proporcionar aos usuários uma experiência prática na gestão de reservas de estacionamento, a aplicação integra um mapa interativo onde os usuários podem visualizar diferentes estacionamentos, acessar informações detalhadas e realizar reservas diretamente através da interface.

Funcionalidades Principais
Mapa Interativo 🗺️: Os usuários podem explorar um mapa que exibe a localização dos estacionamentos disponíveis. Ao clicar em um estacionamento, um pop-up fornece informações detalhadas, como nome, endereço, vagas disponíveis, e preços.

Reserva de Estacionamento 📝: Através do pop-up, os usuários podem iniciar uma reserva selecionando o tempo de permanência e a forma de pagamento. A reserva é então armazenada no banco de dados e pode ser visualizada posteriormente.

Gestão de Reservas 📚: Os usuários podem acessar suas reservas clicando no ícone de livro na navbar, onde poderão visualizar ou excluir suas reservas atuais.

Formas de Pagamento 💳: O sistema permite a seleção de diferentes formas de pagamento, como PIX ou dinheiro, conforme as opções disponíveis para cada estacionamento.

CRUD Completo de Reservas 🔄: A aplicação oferece uma funcionalidade CRUD (Create, Read, Update, Delete) para as reservas, permitindo que os usuários criem, visualizem, editem e excluam suas reservas diretamente pelo sistema.

CRUD de Estacionamentos 🆕: É possível adicionar, editar, visualizar e remover estacionamentos através de um sistema CRUD completo. Os novos estacionamentos são automaticamente integrados ao mapa interativo, permitindo que os usuários os localizem e reservem.

Formulário Integrado 🛠️: Ao clicar em "Alugar" no pop-up de um estacionamento, o usuário é direcionado para um formulário modal onde pode inserir as informações do veículo, selecionar o tempo de permanência e a forma de pagamento. Todos esses dados são então salvos no banco de dados.

Tecnologias Utilizadas
Frontend: Inicialmente desenvolvido com Thymeleaf, o projeto está em processo de migração para Angular, proporcionando uma experiência de usuário mais dinâmica e responsiva.

Backend: Implementado em Java utilizando Spring Boot, com integração ao PostgreSQL para gerenciamento de banco de dados.

Banco de Dados: PostgreSQL, utilizando JPA/Hibernate para mapeamento objeto-relacional.

Dependências Principais:

Spring Boot
Spring Data JPA
Hibernate
PostgreSQL
Thymeleaf (para o frontend inicial)
Lombok (para simplificação de código)
Angular (em migração para o frontend)
Estrutura do Projeto
O Parkeasy segue a arquitetura padrão de Controllers, Models, Repositories, e Services:

Controllers: Responsáveis por gerenciar as requisições HTTP e direcionar as operações para os serviços apropriados.
Models: Representam as entidades do sistema, como Parking e Reservation.
Repositories: Interface para interagir com o banco de dados, utilizando Spring Data JPA.
Services: Contêm a lógica de negócio do aplicativo e interagem com os repositórios para manipulação dos dados.
Como Rodar o Projeto
Clone o repositório:

bash
Copy code
git clone https://github.com/rod-buges/ParkeasyVersionTest.git
Navegue até o diretório do projeto:

bash
Copy code
cd ParkeasyVersionTest
Configure o banco de dados PostgreSQL e ajuste as configurações de conexão em application.properties.

Compile e rode a aplicação com o Maven:

bash
Copy code
mvn spring-boot:run
Acesse a aplicação em http://localhost:8080.

Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para discutir novas funcionalidades ou melhorias.

Licença
Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.
