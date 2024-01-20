package com.aws.cep.awscep.sqs.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SqsConfig {

    @Value("${aws_access_key_id}")
    private String awsId;

    @Value("${aws_secret_access_key}")
    private String awsKey;

    private String region = "us-east-1";

    @Bean
    public AmazonSQS amazonSQS() {
        AWSCredentials credentials = new BasicAWSCredentials(awsId, awsKey);

        return AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.fromName(region))
                .build();
    }
}
