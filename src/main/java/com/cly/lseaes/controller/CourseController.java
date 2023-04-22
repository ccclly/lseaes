package com.cly.lseaes.controller;


import com.cly.lseaes.dto.CourseDTO;
import com.cly.lseaes.entity.Course;
import com.cly.lseaes.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

//    @PostMapping("/save")
//    public String save(@RequestBody CourseDTO courseDTO) {
//        Course course = new Course();
//        course.setName(courseDTO.getName());
//        course.setDescription(courseDTO.getDescription());
//        course.setImgName(courseDTO.getImgName());
//        courseService.saveOrUpdate(course);
//        System.out.println(courseDTO);
//        return "ok";
//    }

    private static final String UPLOAD_DIR = "uploads";

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            // Create the "uploads" directory if it doesn't exist
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the uploaded file
            byte[] bytes = file.getBytes();
            String newName = UUID.randomUUID() + file.getOriginalFilename();
            Path filePath = uploadPath.resolve(newName);
            System.out.println(filePath);
            Files.write(filePath, bytes);

            return ResponseEntity.status(HttpStatus.OK).body(newName);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }


    @GetMapping("/list")
    public List<Course> courseList() {
        return courseService.list();
    }



    @GetMapping("/{id}")
    public CourseDTO getCourseVOById(@PathVariable Integer id) {
        System.out.println(id);
//        List<Object> objects;
//        objects = Collections.singletonList(courseService.selectCourseDTOById(id));
//        System.out.println(objects);
        return courseService.selectCourseDTOById(id);
    }
}
