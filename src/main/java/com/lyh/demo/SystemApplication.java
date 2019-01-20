package com.lyh.demo;

import com.lyh.demo.api.HelloApi;
import io.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import java.io.File;
import javax.sql.DataSource;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;


@EnableFeignClients(clients = HelloApi.class)
@EnableDiscoveryClient
@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}


//	@Bean
	@SneakyThrows
	public DataSource test(){
//		File yamlFile= ResourceUtils.getFile("classpath:sharding-jdbc.yaml");
		Resource resource= new DefaultResourceLoader(this.getClass().getClassLoader()).getResource("classpath:sharding-master-slave.yaml");
		File yamlFile=resource.getFile();
		return YamlMasterSlaveDataSourceFactory.createDataSource(yamlFile);
	}

}

