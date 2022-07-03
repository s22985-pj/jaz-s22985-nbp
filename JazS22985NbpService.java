package com.example.jazs22985nbp;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JazS22985NbpService {
    final JazS22985Repository jazS22985Repository;
    final RestTemplate restTemplate;
    JazS22985NbpService(JazS22985Repository jazS22985Repository, RestTemplate restTemplate){
    this.jazS22985Repository=jazS22985Repository;
    this.restTemplate=restTemplate;
    }

    public JazS22985NbpEntity getWaluta( String code, String waluta, String startDate, String endDate) {
        JazS22985NbpEntity exchange = restTemplate.getForEntity("http://api.nbp.pl/api/cenyzlota/2013-01-01/2013-01-31/" + code
        + "/" +waluta+"/"+startDate+"/"+endDate+"/", JazS22985NbpEntity.class).getBody();
    return jazS22985Repository.save(exchange);
    }

    public JazS22985NbpEntity getId(Long id){
        return jazS22985Repository.findById(id).get();
    }
}
