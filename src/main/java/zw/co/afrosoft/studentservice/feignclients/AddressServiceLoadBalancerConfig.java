//package zw.co.afrosoft.studentservice.feignclients;
//
//import feign.Feign;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//
//@LoadBalancerClient(value = "address-service")
//public class AddressServiceLoadBalancerConfig {
//    @LoadBalanced
//    @Bean
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }
//}

//If we are using the API gateway we dont need to have an implementation of the loadbalancer coz the API-GATEWAY will do the loadbalancing for us by default
