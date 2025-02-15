package com.estudo.project.config;
import com.estudo.project.domain.repositories.PlaceRepository;
import com.estudo.project.domain.services.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

    @Bean
    public PlaceService placeService(PlaceRepository placeRepository) {
         return new PlaceService(placeRepository);
    }
}
