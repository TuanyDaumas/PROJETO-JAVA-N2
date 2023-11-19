
2.1- Adeque a interface para com usuário substituindo GUI Swing por uma equivalente usando projeto JavaFX (no NetBeans, usar "Java with Maven"). A interface deverá ter 2 partes de tipos de manipulação de dados: 1- Persistência em arquivos XML e Jason (seções 2.2 e 2.3); e, 2- Persistência em SGBD (seção 2.4). 

2.2- Demonstre a persistência de dados de empregados cadastrados em XML, p. ex., criando menu/botões de "escrita" e "leitura" no referido padrão. Assim:

> "Escrita": Um ArrayList de empregados foi usado para cadastro, logo deverá usar dados desta ED para geração do arquivo de cadastro, permitindo ao usuário escolher local e nome do arquivo no salvamento. Observe que o ArrayList original em RAM não precisará ser apagado, permitindo as opções de interface originais para cadastro/deleção/consulta de funcionários. 

> "Leitura": deverá permitir que o usuário navegue até um arquivo de dados no padrão para que ocorra a leitura, refazendo o ArrayList de Empregados em memória RAM. Obs.: Eventuais dados contidos no ArrayList deverão ser substituídos pelos lidos a partir do aquivo. A opção de Consulta ao ArrayList deverá permitir conferir Empregados lidos, apresentando-os adequadamente (em tabela, p. ex.).

2.3- Similar ao anterior, demonstre a persistência de dados de empregados cadastrados em JSON, p. ex., criando menu/botões de "escrita" e "leitura" no referido padrão.

Obs.: Crie classes específicas com métodos de persistência de dados, separando-as para XML e JSON. Lembre-se, estruture "Packages" em seu projeto de forma a separar as classes desenvolvidas conforme seus tipos na aplicação (front-end, back-end, interface, persistência (EntityManager), etc.). Documentar README explicativo.

2.4- Crie classe java especializada na persistência de dados em SGBD Postgres, de modo a sincronizar o cadastro de Empregados no banco de dados (tabelas deverão ser modeladas conforme o diagrama de classes proposto). Assim, toda vez que um Empregado for cadastrado, este deverá ser armazenado no banco de dados. Do mesmo modo, ao optar por Remover um Empregado, este deverá ser excluído do Banco após consulta prévia que certificará sua ocorrência (uma tabela pode ser usada para mostrar Empregados cadastrados no Banco). Obs.: Agregar ao README uma explicação com prints de como configurar o SGBD Postgres e promover comunicação de dados.

Obs. Geral:  Enviar ZIP da pasta do projeto NetBeans + README.
AVALIAÇÃO: Combinamos que um vídeo explicativo do projeto deverá ser publicado e o link de acesso disposto no início do README exigido. As etapas de demonstração de configuração e testes deverão ser realizadas para as funcionalidades na sequência 2.1 a 2.4. 