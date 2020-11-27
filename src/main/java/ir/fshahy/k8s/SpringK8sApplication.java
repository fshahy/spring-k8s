package ir.fshahy.k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringK8sApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringK8sApplication.class, args);
	}

}
