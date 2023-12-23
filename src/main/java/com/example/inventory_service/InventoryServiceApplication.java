package com.example.inventory_service;

import com.example.inventory_service.entities.Creator;
import com.example.inventory_service.entities.Video;
import com.example.inventory_service.repository.CreatorRepository;
import com.example.inventory_service.repository.VideoRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (VideoRepository videoRepository , CreatorRepository creatorRepository)
    {
        return args -> {
            Creator creator = Creator.builder()
                    .id(1L)
                    .name("karim")
                    .email("karim@gmail.com")
                    .build();


            Creator creator1 = Creator.builder()
                    .id(2L)
                    .name("oda")
                    .email("oda@gmail.com")
                    .build();
            creatorRepository.saveAll(List.of(creator,creator1));
            Video v = Video.builder().name("video1").url("urlvideo1").description("descriptionVideo1").date_prod(new Date()).creator(creator).build();
            Video v2 = Video.builder().name("video2").url("urlvideo2").description("descriptionVideo2").date_prod(new Date()).creator(creator1).build();
            Video v3 = Video.builder().name("video3").url("urlvideo3").description("descriptionVideo3").date_prod(new Date()).creator(creator1).build();

            videoRepository.saveAll(List.of(v,v2,v3));

        };
    }
}
