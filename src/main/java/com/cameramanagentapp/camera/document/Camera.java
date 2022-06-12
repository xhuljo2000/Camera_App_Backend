package com.cameramanagentapp.camera.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Camera {
    @Transient
    public static final String SEQUENCE_NAME = "cameras_sequence";

    @Id
    private Long id;
    private String name;
    private String model;
    private Long resolution;
    private String ip;

    public Camera(String name, String model, Long resolution, String ip) {
        this.name = name;
        this.model = model;
        this.resolution = resolution;
        this.ip = ip;
    }
}
