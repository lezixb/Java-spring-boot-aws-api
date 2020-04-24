package com.xardtek.awscloudserivces.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.xardtek.awscloudserivces.services.S3Mastermind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class endpoint {

@Autowired
S3Mastermind s3Mastermind;

    @GetMapping(path = "/buckets")
    public List<Bucket> listBuckets(){
        return s3Mastermind.getAllBuckets();
    }
}
