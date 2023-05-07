package nizam.in.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nizam.in.binding.Courses;
import nizam.in.service.CourseService;

@RestController
//@RequestMapping(path = "/RestApi",produces = "application/json")
@CrossOrigin(origins = "*")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public ResponseEntity<String> getcourse() {
		String st = "welcome to course Application ";
		return new ResponseEntity<>(st, HttpStatus.OK);
	}

	@GetMapping("/getallcourse")
	public ResponseEntity<List<Courses>> getAllCourses() {
		List<Courses> getcourse = courseService.getcourse();

		return new ResponseEntity<>(getcourse, HttpStatus.OK);

	}

	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Object> getCourse(@PathVariable String courseId) {
		Optional<Courses> courseById = courseService.getCourseById(Long.parseLong(courseId));
		return new ResponseEntity<Object>(courseById, HttpStatus.OK);
	

	}

	@PostMapping("/course")
	public ResponseEntity<Courses> addCourse(@RequestBody Courses courses) {
		Courses addCourse = courseService.addCourse(courses);
		return new ResponseEntity<>(addCourse, HttpStatus.CREATED);
	}

	@PutMapping("/courses")
	ResponseEntity<Courses> updateCourse(@RequestBody Courses courses) {
		Courses updateCourse = courseService.updateCourse(courses);
		return new ResponseEntity<Courses>(updateCourse, HttpStatus.OK);

	}
    @DeleteMapping("/courses/{courseId}")
	ResponseEntity<String> deleteCourses(@PathVariable String courseId) {
		try {

			courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("something went to wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    @PostMapping("/courses/{courseId}")
   	ResponseEntity<String> updateCoursesById(@PathVariable String courseId) {
   		try {
   			courseService.updateCourseById(Long.parseLong(courseId));
   			return new ResponseEntity<>("update done",HttpStatus.OK);
   		} catch (Exception e) {
   			return new ResponseEntity<>("something went to wrong",HttpStatus.INTERNAL_SERVER_ERROR);
   		}
   	}

}
