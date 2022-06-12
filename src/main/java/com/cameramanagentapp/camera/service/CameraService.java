package com.cameramanagentapp.camera.service;



import com.cameramanagentapp.camera.document.Camera;

import java.util.List;

public interface CameraService {
    List<Camera> getAllCameras();

    Camera saveCamera(Camera cameras);

    Camera getCameraById(Long id);

    Camera updateCamera(Camera cameras);

    void deleteCameraById(Long id);
}
