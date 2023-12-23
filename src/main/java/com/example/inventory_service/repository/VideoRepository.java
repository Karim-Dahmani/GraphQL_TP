package com.example.inventory_service.repository;

import com.example.inventory_service.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
