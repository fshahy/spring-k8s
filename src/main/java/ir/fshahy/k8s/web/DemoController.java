package ir.fshahy.k8s.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {
	@Autowired
	protected DiscoveryClient discovery;
	
	RestTemplate rest = new RestTemplate();
	
	@GetMapping
	public ResponseEntity<String> hello() {
		List<ServiceInstance> services = this.discovery.getInstances("spring-k8s-svc1");
		if (services.size() == 1) {
			URI uri = services.get(0).getUri();
			
			ResponseEntity<String> greeting = rest.getForEntity(uri.toString(), String.class);
			return greeting;
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
//		ResponseEntity<String> greeting = rest.getForEntity("http://localhost:9090/greeting", String.class);
//		return greeting;
	}
}
