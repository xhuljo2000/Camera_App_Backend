package com.cameramanagentapp.camera.service.impl;

import com.cameramanagentapp.camera.document.Camera;
import com.cameramanagentapp.camera.repository.CameraRepository;
import com.cameramanagentapp.camera.service.CameraService;
import com.cameramanagentapp.camera.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private SequenceGeneratorService seqGeneratorService;

    private CameraRepository cameraRepository;

    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @Override
    public List<Camera> getAllCameras() {
        return cameraRepository.findAll();
    }

    @Override
    public Camera saveCamera(Camera camera) {
        camera.setId(seqGeneratorService.generateSequence(Camera.SEQUENCE_NAME));
        return cameraRepository.save(camera);
    }

    @Override
    public Camera getCameraById(Long id) {
        return cameraRepository.findById(id).get();
    }

    @Override
    public Camera updateCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    @Override
    public void deleteCameraById(Long id) {
        cameraRepository.deleteById(id);
    }
}
