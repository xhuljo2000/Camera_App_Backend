package com.cameramanagentapp.camera.repository;


import com.cameramanagentapp.camera.document.Camera;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CameraRepository extends MongoRepository<Camera, Long> {

    //Iterable<Object> findByIp(String ip);
}
