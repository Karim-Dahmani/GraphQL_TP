package com.example.inventory_service.Mapper;

import com.example.inventory_service.dtos.CreatorRequest;
import com.example.inventory_service.dtos.VideoRequest;
import com.example.inventory_service.entities.Creator;
import com.example.inventory_service.entities.Video;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class VideoMapper {
    public Video fromVideoRequest(VideoRequest videoRequest){
        Video video = new Video();
        BeanUtils.copyProperties(videoRequest, video);
        video.setCreator(this.fromCreatorRequest(videoRequest.getCreator()));
        return video;
    }

    public Creator fromCreatorRequest(CreatorRequest creatorRequest){
        Creator creator = new Creator();
        BeanUtils.copyProperties(creatorRequest, creator);
        return creator;
    }

}
