# xy-inc
Este repositório contém os arquivos referentes ao teste proposto pela empresa Zup para avaliação de conhecimento.

#Arquivos do Repositório
O servidor webservice está denominado por WebApp.zip e o frontend WebClient.zip.
O arquivo banco.sql refere-se ao script de criação do banco de dados no MySql com sua respectiva tabela e campos necessários para o funcionamento do programa.
O diretório do programa também está diretamente na raiz do repositório para sincronização com programa cliente do git.

#Sobre o desenvolvimento.
O webservice foi desenvolvido na linguagem Java utilizando a biblioteca Jersey para criação do webservice e a biblioteca Hibernate para persistência dos dados no banco de dados. Optei por utilizar os dois frameworks visando uma possível evolução e expansão da aplicação, visto que o Hibernate é um dos frameworks mais utilizados atualmente por ser uma ferramenta robusta e que tem um bom desempenho assim como o Jersey que executa muito bem o papgel na criação do webservice e também pelo fato de permitir a comunicação via json que é um ótimo formato de comunicação. Utilizei o Maven para garantia da instalação das bibliotecas assim como as versões que foram testadas e validadas. Utilizei o banco de dados MySql que por mais que não seja o mais robusto do mercado ainda assim pode atender perfeitamente a necessidade proposta, além do mais como foi utilizado o Hibernate seria relativamente simples a migração para outro banco de dados, se caso for necessário.
Foi desenvolvido também um app cliente o qual, até o momento, consome apenas o serviço de busca de todos os "products" cadastrados.

#Instalação
É necessário a criação do banco de dados no MySql e também a criação do usuário "root" e senha "root" ou então alterar o aquivo de configuração persistence.xml, contido no caminho WebApp/src/main/resources/META-INF, informando o usuário e senha disponíveis no banco de dados.
A aplicação java deve ser executada no servidor Apache Tomcat 8.5 e como a porta foi fixada no fonte do app frontend, será necessário utilizar a porta "8080" para executar o programa WebApp, que é o servidor webservice, ou então será necessário alterar o arquivo ProductsMB.java do app frontend, contido no caminho WebClient/src/main/java/br/com/raphael/xyincclient/managedbean, e informar a porta do Tomcat na variável URL_SERVICE.
O app frontend pode ser executado em qualquer porta.

#Testes
Os testes podem ser executados pelo aplicativo SoapUI, por exemplo, chamando os métodos listados abaixo referentes ao seu protocolo de envio:<br>
GET - getall<br>
GET - getproduct/{id}<br>
POST - add<br>
PUT - edit<br>
DELETE - delete/{id}<br>
O caminho completo para execução, se utilizada a porta 8080 em um servidor local, fica da seguinte forma:<br> "http://localhost:8080/WebApp/rest/products/" seguida pelo método selecionado.<br>
O campos de cadastro são: name(String), description(String), price(float) e category(String).<br>
A chamada do método de inclusão ficaria da seguinte forma:<br>
http://localhost:8080/WebApp/rest/products/add passando o modelo de json abaixo:<br>
{
	"name":"Name Product",
	"description":"Description Product",
	"price":1000,
	"category":"Category Product"
	} <br>
  A chamada do método de edição:<br>
  http://localhost:8080/WebApp/rest/products/edit passando o modelo de json abaixo:<br>
{
  "id":**ID do registro a ser alterado**
	"name":"Name Product",
	"description":"Description Product",
	"price":1000,
	"category":"Category Product"
	} <br>
  A chamada do método de exclusão: <br>
  http://localhost:8080/WebApp/rest/products/delete/**ID do registro a ser excluído**<br>
  A chamada do método de busca todos: <br>
  http://localhost:8080/WebApp/rest/products/getall<br>
  A chamada do método busca produto por ID:<br>
  http://localhost:8080/WebApp/rest/products/getproduct/**ID do registro a ser buscado**
  
  #Notas
  O app frontend foi desenvolvido apenas chamando o método getall, e já está apontando para a pagina index.
