package com.example.jazs22985nbp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NBP")


public class JazdS22985NbpRestController {
    final JazS22985NbpService jazS22985NbpService;

    public JazdS22985NbpRestController(JazS22985NbpService jazS22985NbpService) {this.jazS22985NbpService = jazS22985NbpService;}

    @GetMapping("/waluta/{code}/{waluta}/{startDate}/{endDate}")
    public JazS22985NbpEntity all(@PathVariable String code, @PathVariable String waluta, @PathVariable String startDate, @PathVariable String endDate){
        return jazS22985NbpService.getWaluta(code, waluta, startDate, endDate);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JazS22985NbpEntity> back(@PathVariable Long id) {return ResponseEntity.ok(jazS22985NbpService.getId(id));}
}
