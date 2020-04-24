package com.xardtek.awscloudserivces.services;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S3Mastermind {
    final private org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AmazonS3Client amazonS3Client;


    public void CreateBucket(String BucketName){
        BucketName="xardtek-dev-bucket";

        if(amazonS3Client.doesBucketExist(BucketName)) {
            log.info("Bucket name Unavailable");
            return;
        }
        amazonS3Client.createBucket(BucketName);
        log.info(BucketName+ " Successfully Created! ");
    }

    public List<Bucket> getAllBuckets() {
        int counter=0;
        List<Bucket> buckets= amazonS3Client.listBuckets();
        for(Bucket bucket : buckets ){
            counter++;
            log.info("Bucket"+counter+" ::: "+ bucket);
        }
        return amazonS3Client.listBuckets();
    }

}
