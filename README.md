JaxRsCache
==========

O JaxRsCache é uma biblioteca de de armazenamento e recuração de dados em cache integrada com Jersey (1.+), 
que proporciona acesso a dados antes mesmo de chegar na sua aplicação. 

Embora não seja um cache de nível do servidor o JaxRsCache trata as requisições antes dela chegarem ao seu recurso RestFul e caso encontre um valor 
armazenado para aquela URI retorna o valor dentro do response. 

Desta maneira este cache é provavelmente o mais rápido para aplicações RestFul pois dispensa a criação da sua classe RestFul ou qualquer dependência dentro dela.
