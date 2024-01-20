# aws-resources
## Projeto que utiliza 7 Recursos da AWS
### 1 - VPC
### 2 - EC2
### 3 - IAM
### 4 - ElastiCache - Redis
### 5 - RDS - Postgres
### 6 - SQS
### 7 - BucketS3
![0001](https://github.com/DouglasSilvar/aws-resources/assets/74723511/06a4a7f8-ea45-4f25-9bce-953c30b8cdfe)

# Alguns comandos para utilizar de exemplo que utilizei:

## Para habilitar internet na EC2
### sudo resolvectl dns eth0 8.8.8.8 8.8.4.4
### sudo resolvectl domain eth0 ~.

## Comando para acessar a EC2 em formato Bastion com porta habilitada para a conexão
### ssh -v -i "parX.pem" -N -L 6379:eeee.5nqg31.ng.0001.use1.cache.amazonaws.com:6379 ubuntu@54.158.228.220

# Playlist do projeto
## 1 - https://youtu.be/ZMjSGq7Fwb4 -- Apresentação da arquitetura
## 2 - https://youtu.be/EHRFDLydRy4 -- Criação dos recursos na AWS
## 3 - https://youtu.be/7nAqBgJIMDw -- Teste de conexão com os recursos 
## 4 - https://youtu.be/EzLC8soTumU -- Desenvolvimento do código
## 5 - https://youtu.be/ENFJx9wdm1E -- Teste do código e fluxo geral



