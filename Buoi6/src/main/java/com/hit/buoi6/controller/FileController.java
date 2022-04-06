package com.hit.buoi6.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    private final Path rootPath = Paths.get(System.getProperty("user.dir"));

    @PostMapping
    public String uploadFile(@RequestPart(value = "img", required = false) MultipartFile file) throws IOException {
        //D:\Spring boot_HIT_2022\Buoi6\src\main\resources\static
        Path path = Paths.get(rootPath + "/src/main/resources/static/");

        Path path2 = path.resolve(file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(path2)) {
            os.write(file.getBytes());
        }

        return file.getOriginalFilename();
    }

}
