package com.singraul.boot.restapi.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class ProductConfigCache {

	@Bean
	public Config cacheConfig() {
		return new Config().setInstanceName("hazle-instance")
				.addMapConfig(new MapConfig().setName("product-cache")
						.setTimeToLiveSeconds(3000));
		
	}
}
