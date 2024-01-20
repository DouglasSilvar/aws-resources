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
