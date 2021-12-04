package zw.co.afrosoft.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zw.co.afrosoft.studentservice.domain.response.AddressResponse;

@FeignClient(url = "${address.service.url}",value = "address-feign-client",path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("/getById/{id}")
    ResponseEntity<AddressResponse> getById(@PathVariable Long id);
}
