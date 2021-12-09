package zw.co.afrosoft.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zw.co.afrosoft.studentservice.domain.response.AddressResponse;

@FeignClient(value = "api-gateway")
public interface AddressFeignClient { //This is no longer specific to the address service

    @GetMapping("address-service/api/address/getById/{id}")
    AddressResponse getById(@PathVariable Long id);
}
