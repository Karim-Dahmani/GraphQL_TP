package com.example.inventory_service.web;


import com.example.inventory_service.Mapper.VideoMapper;
import com.example.inventory_service.dtos.CreatorRequest;
import com.example.inventory_service.dtos.VideoRequest;
import com.example.inventory_service.entities.Creator;
import com.example.inventory_service.entities.Video;
import com.example.inventory_service.repository.CreatorRepository;
import com.example.inventory_service.repository.VideoRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@AllArgsConstructor
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
     private VideoMapper videoMapper;

    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public Creator creator(@Argument Long id){
        return creatorRepository.findById(id).get();
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator){
        Creator creator1 = videoMapper.fromCreatorRequest(creator);
        return creatorRepository.save(creator1);
    }

    @MutationMapping
    public Video saveVideo(@Argument VideoRequest video){
        Video video1 = videoMapper.fromVideoRequest(video);
        System.out.println(video1);
        Creator creator = creatorRepository.save(video1.getCreator());
        video1.setCreator(creator);
        return videoRepository.save(video1);
    }
}