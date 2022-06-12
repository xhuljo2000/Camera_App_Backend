package com.cameramanagentapp.camera.resource;

import com.cameramanagentapp.camera.document.Camera;
import com.cameramanagentapp.camera.repository.CameraRepository;
import com.cameramanagentapp.camera.service.CameraService;
import com.cameramanagentapp.camera.service.impl.CameraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class CameraResource {
/*
    

    private final CameraServiceImpl cameraService;

    @Autowired
    public CameraResource(CameraServiceImpl cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Camera>> getAllCameras() {
        List<Camera> cameras = cameraService.getAllCameras();
        return new ResponseEntity<>(cameras, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Camera> getCameraById(@PathVariable("id") Long id) {
        Camera camera = cameraService.getCameraById(id);
        return new ResponseEntity<>(camera, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Camera> addCamera(@RequestBody Camera camera) {
        Camera newCamera = cameraService.saveCamera(camera);
        return new ResponseEntity<>(newCamera, HttpStatus.CREATED);
    }

    @PutMapping("/find/{id}")
    public ResponseEntity<Camera> updateCamera(@RequestBody Camera camera) {
        Camera updateCamera = cameraService.updateCamera(camera);
        return new ResponseEntity<>(updateCamera, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCamera(@PathVariable("id") Long id) {
        cameraService.deleteCameraById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }*/
}