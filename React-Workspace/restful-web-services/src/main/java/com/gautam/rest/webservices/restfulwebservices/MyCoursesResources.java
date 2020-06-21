package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MyCoursesResources {

    @Autowired(required = true)
    private MyCoursesHardcodeService mycoursesservice;


    @GetMapping(path = "/users/{username}/mycourses")
    public List<MyCourses> getAllMyCourses(@PathVariable String username) {
        return mycoursesservice.findAll();
    }

    @GetMapping(path = "/users/{username}/mycourses/{id}")
    public MyCourses getSingleMyCourse(@PathVariable String username, @PathVariable int id) {
        MyCourses myCourse_id = mycoursesservice.findByid(id);
        return myCourse_id;
    }


    @DeleteMapping(path = "/users/{username}/mycourses/{id}")
    public ResponseEntity<Void> deleteMyCourses(@PathVariable String username, @PathVariable int id) {
        MyCourses myCourse = mycoursesservice.deleteById(id);
        if (myCourse != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/users/{username}/mycourses/{id}")
    public ResponseEntity<MyCourses> updateCourses(@PathVariable String username, @PathVariable long id,
                                                   @RequestBody MyCourses myCourses) {

        MyCourses updatedCourse = mycoursesservice.Save(myCourses);
        return new ResponseEntity<MyCourses>(myCourses, HttpStatus.OK);

    }

    @PostMapping(path = "/users/{username}/mycourses")
    public ResponseEntity<Void> createNewCourse(@PathVariable String username,
                                                @RequestBody MyCourses myCourses) {

        MyCourses createdCourse = mycoursesservice.Save(myCourses);
        //Get Current URL location and append it with new created ID
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdCourse.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
