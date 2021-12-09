package zw.co.afrosoft.studentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.studentservice.domain.response.AddressResponse;
import zw.co.afrosoft.studentservice.feignclients.AddressFeignClient;

@Service
public class CommonService {

    @Autowired
    private AddressFeignClient addressFeignClient;

    @CircuitBreaker(name = "addressService",
            fallbackMethod = "fallbackGetAddressById")
    public AddressResponse getAddressById(Long addressId) {
        AddressResponse addressResponse = addressFeignClient.getById(addressId);
        return addressResponse;
    }
    public AddressResponse fallbackGetAddressById(Long addressId, Throwable th) {
        return  new AddressResponse();
    }
}
