# language: pt

Funcionalidade: testar uma API
  Testar API local

  @get
  Cenário: Obter um cliente existente
    Dado que a URI base é configurada
    Quando eu enviar uma requisição GET para obter o cliente em "/api/clientes/4"
    Então o código de resposta no GET deve ser 200
    E a resposta deve conter informações do cliente

  @post
  Cenário: Criar um novo cliente
    Dado que a URI base é configurada
    E o corpo da requisição POST é configurado
    Quando eu enviar uma requisição POST para criar um cliente em "/api/clientes"
    Então o código de resposta no POST deve ser 201
    E a resposta deve conter o ID do cliente criado

  @put
  Cenário: Atualizar informações de um cliente
    Dado que a URI base é configurada
    E o corpo da requisição PUT é configurado
    Quando eu enviar uma requisição PUT para atualizar o cliente em "/api/clientes/4"
    Então o código de resposta deve ser 200
    E a resposta deve conter informações atualizadas do cliente


  @delete
  Cenário: Excluir um cliente
    Dado que a URI base é configurada
    Quando eu enviar uma requisição DELETE para excluir o cliente em "/api/clientes/4"
    Então a resposta deve ser 204
