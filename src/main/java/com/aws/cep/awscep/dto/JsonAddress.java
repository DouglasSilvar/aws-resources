package com.aws.cep.awscep.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonAddress {

    public static String toJson(AddressDTO addressDTO){
        log.info("Start serializing object to json: "+addressDTO.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json =  mapper.writeValueAsString(addressDTO);
            log.info("Finish serializing object to json: "+json);
            return json;
        } catch (JsonProcessingException e) {
            log.error("Fail to serialize object to json: "+addressDTO.toString());
            throw new RuntimeException(e);
        }
    }
    public static AddressDTO toAddress(String json){
        log.info("Start deserializing json to Object: "+json);
        ObjectMapper mapper = new ObjectMapper();
        try {
            var address =  mapper.readValue(json,AddressDTO.class);
            log.info("Finish deserializing json to Object: "+address);
            return address;
        } catch (JsonProcessingException e) {
            log.info("Fail to deserializing json to Object: "+json);
            throw new RuntimeException(e);
        }
    }

}
