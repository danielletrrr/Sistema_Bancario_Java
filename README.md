Este é o meu primeiro projeto em Java após estudar Programação Orientada a Objetos (POO).

O objetivo do projeto é aplicar, de forma prática, os pilares da orientação a objetos, utilizando um sistema simples de conta bancária executado via terminal.
O sistema consiste, inicialmente, em permitir que um usuário utilize o terminal para:

Criar uma conta bancária
Acessar sua conta
Realizar operações bancárias básicas:
  Saque
  Depósito
  Consulta de saldo

A aplicação permite que o usuário crie uma conta bancária, acesse essa conta e realize operações básicas, como saque, depósito e consulta de saldo,
tudo por meio da interação com o terminal.
O sistema foi modelado a partir da abstração de uma conta bancária, representada pela classe ContaBancaria, que possui atributos essenciais como nome do titular,
CPF, saldo, número da agência e número da conta. Os métodos principais dessa classe são sacar e depositar, responsáveis por validar e executar as operações financeiras.

Para capturar os dados informados pelo usuário, foi utilizada a biblioteca Scanner. As informações digitadas no terminal são armazenadas em memória e utilizadas tanto 
no momento da criação da conta quanto no acesso e execução das operações bancárias.
O fluxo da aplicação é controlado por menus interativos construídos com a estrutura de controle switch case. No método responsável pela criação da conta, 
é utilizado um gerador randômico para definir automaticamente o número da conta e da agência após o usuário informar seu nome, CPF e saldo inicial.

Ao entrar na conta, o sistema solicita o número da agência e da conta e verifica se essas informações correspondem a uma conta existente em memória. 
Caso os dados estejam corretos, a conta é encontrada e o sistema exibe as informações do titular, como nome, agência, número da conta e saldo atual.

Após o acesso, um novo menu é apresentado, permitindo que o usuário utilize as funcionalidades disponíveis da conta, como sacar ou depositar valores. 
Essas opções chamam os métodos correspondentes da conta bancária, garantindo a separação entre a lógica de negócio e o controle do fluxo do sistema.

Para manter o código mais organizado e limpo, foi criada uma classe responsável pelos serviços da conta, centralizando as operações bancárias e facilitando a manutenção 
e a evolução do projeto. O uso de switch case também foi aplicado nessa camada para direcionar corretamente as ações escolhidas pelo usuário.

Este projeto tem como principal finalidade consolidar os conceitos iniciais de orientação a objetos em Java, praticar a organização do código e simular o funcionamento 
básico de um sistema bancário. A ideia é evoluí-lo futuramente com novas funcionalidades, como transferências via Pix, extrato bancário e persistência de dados.
