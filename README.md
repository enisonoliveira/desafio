# desafio
#banco de dados mongo + spring boot + docker container + swegger

#configurando pra rodar com o docker 
comente a linha na pasta resource configuration.properties  a linha 8 adicionando um # e descomente a linha 12

gerar o demo.jar com o manve rodando o comando >mvn package -Dmaven.test.skip
criar o container com o comando > docker build -t api-ibm-eso .
suba todas as imagem rodando o compose >docker-compose up

#acesse o swegger na url
http://localhost:9091/swagger-ui.html#!

#exemplo de como montar o ambiente em video mp4
https://user-images.githubusercontent.com/24898873/161849034-11220355-4a76-415e-a220-56cf73d266e3.mp4


#todos os endpoit
![Screenshot from 2022-04-05 18-10-39](https://user-images.githubusercontent.com/24898873/161849786-4aae77d9-92d4-47b7-9d06-417785288881.png)



