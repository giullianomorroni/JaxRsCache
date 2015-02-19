JaxRsCache
==========

O JaxRsCache é uma biblioteca de de armazenamento e recuperação de dados em cache integrada com Jersey (1.+), 
que proporciona acesso a dados através de um interceptador de requisições. Seu uso é simples e intuitivo.

Embora não seja um cache de nível do servidor (Http Apache ou IIS) o JaxRsCache trata as requisições antes mesmo dela chegarem ao seu objeto RestFul. O que garante alta performance em respostas e baixa latência. 

Sendo assim, esta biblioteca de cache é provavelmente o melhor caminho para aplicações RestFul que precisam de respostas rápidas e economia de recursos no servidor de aplicação.

Os objetos são armazenados em cache de acordo com a a URL recebida. Por exemplo: http://seu_site.com/cliente/1 retornaria o cliente com ID igual a 1. Após o primeiro acesso aos dados, você pode programaticamente associar essa URL ao objeto cliente com ID igual a 1. Além disso é possível determinar um TTL (tempo de vida) para esses objetos residirem na memória.
