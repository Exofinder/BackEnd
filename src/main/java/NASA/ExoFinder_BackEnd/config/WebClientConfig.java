package NASA.ExoFinder_BackEnd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${ai.server.url}")
    String fastApiUrl;

    @Bean
    WebClient webClient(WebClient.Builder webClientBuilder) { return webClientBuilder.baseUrl(fastApiUrl).build(); }
}
