package zw.co.afrosoft.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zw.co.afrosoft.studentservice.domain.response.AddressResponse;

@FeignClient(value = "address-service",path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("/getById/{id}")
    AddressResponse getById(@PathVariable Long id);
}
