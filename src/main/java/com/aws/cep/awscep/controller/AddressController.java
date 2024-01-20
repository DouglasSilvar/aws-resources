package com.aws.cep.awscep.controller;

import com.aws.cep.awscep.dto.AddressDTO;
import com.aws.cep.awscep.log.LogComponent;
import com.aws.cep.awscep.worker.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/address")
public class AddressController {

    private final WorkerService workerService;
    private final LogComponent logComponent;
    @GetMapping(value = "/{cep}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable(value = "cep") String cep){
        log.info("Starting get CEP: "+ cep + "  -----------------------------------------"+ cep);
        var address = workerService.getCep(cep);
        log.info("Result get CEP: "+ address.toString());
        log.info("Finishing get CEP: "+ cep + "  -----------------------------------------"+ cep);
        this.logComponent.logWorker();
        return ResponseEntity.ok().body(address);
    }
}
