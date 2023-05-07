package nizam.in.service;

import java.util.List;
import java.util.Optional;

import nizam.in.binding.Courses;

public interface CourseService {
	
	public List<Courses>getcourse();
	public Optional<Courses> getCourseById(Long courseId);
	public Courses addCourse(Courses courses);
	public Courses updateCourse(Courses courses);
	public void deleteCourse(Long courseId);
	public void updateCourseById(Long courseId);

}
