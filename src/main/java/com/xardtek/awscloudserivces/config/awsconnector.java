package com.xardtek.awscloudserivces.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class awsconnector {

    final private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());


    @Value("${cloud.aws.credentials.accessKey}")
    String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    String accessSecret;


    @Bean
    @Primary
    public AmazonS3Client generateS3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey,accessSecret);
        AmazonS3Client client = new AmazonS3Client(credentials);
        return client;
    }
}
