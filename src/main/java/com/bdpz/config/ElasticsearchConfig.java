package com.bdpz.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SuppressWarnings("deprecation")
@EnableElasticsearchRepositories(basePackages = "com.bdpz.repository")
@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

	@Value("${elasticsearch.host:localhost}")
	private String host;
	
	@Value("${elasticsearch.port:9200}")
	private String port;
	
	@Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo(host + ":" + port)
            .build();

        return RestClients.create(clientConfiguration).rest();
    }

}