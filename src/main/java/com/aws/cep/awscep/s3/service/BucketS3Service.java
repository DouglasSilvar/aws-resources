package com.aws.cep.awscep.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Slf4j
@Service
@RequiredArgsConstructor
public class BucketS3Service {

    @Value("${bucket.name}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    public void uploadFile(File file) {
        String newFileName = getFormattedDateTime() + ".log";
        log.info("S3 - Iniciando Upload do arquivo para o S3: "+newFileName);
        amazonS3.putObject(new PutObjectRequest(bucketName, newFileName, file));
        log.info("S3 - Finalizado Upload do arquivo para o S3: "+newFileName);
    }

    private String getFormattedDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy---HH:mm:ss---SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("America/Sao_Paulo"));
        return sdf.format(new Date());
    }
}
