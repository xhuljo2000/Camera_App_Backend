package com.cameramanagentapp.camera.controller;

import com.cameramanagentapp.camera.ResourceNotFoundException;
import com.cameramanagentapp.camera.document.Camera;
import com.cameramanagentapp.camera.repository.CameraRepository;
import com.cameramanagentapp.camera.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CameraController {

    @Autowired
    private SequenceGeneratorService seqGeneratorService;

    @Autowired
    private CameraRepository cameraRepository;

    @PostMapping("/cameras")
    public Camera addCamera(@RequestBody Camera camera) {
        camera.setId(seqGeneratorService.generateSequence(Camera.SEQUENCE_NAME));
        return cameraRepository.save(camera);
    }


    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> getAllCameras() {
        return ResponseEntity.ok(cameraRepository.findAll());
    }

    @GetMapping("/camera/{id}")
    public ResponseEntity<Camera> getCameraById(@PathVariable Long id)
            throws ResourceNotFoundException {
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camera not found for this id :: " + id));
        return ResponseEntity.ok(camera);
    }

    @PutMapping("/cameras/{id}")
    public ResponseEntity<Camera> updateCamera(@PathVariable(value = "id") Long id,
                                         @RequestBody Camera cameraDetails){
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camera not found for this id :: " + id));

        camera.setName(cameraDetails.getName());
        camera.setModel(cameraDetails.getModel());
        camera.setResolution(cameraDetails.getResolution());
        camera.setIp(cameraDetails.getIp());

        final Camera updatedCamera = cameraRepository.save(camera);
        return ResponseEntity.ok(updatedCamera);
    }

    @DeleteMapping("/cameras/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(value = "id") Long cameraId)
            throws ResourceNotFoundException {
        Camera camera = cameraRepository.findById(cameraId)
                .orElseThrow(() -> new ResourceNotFoundException("Camera not found for this id :: " + cameraId));

        cameraRepository.delete(camera);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
