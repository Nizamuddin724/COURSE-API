package nizam.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sentry.Sentry;
import nizam.in.binding.Courses;
import nizam.in.repo.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	//List<Courses> list;
	

	@Autowired
	private CourseRepo courseRepo;
	
	public CourseServiceImpl() {
		/*
		 * list = new ArrayList<>(); list.add(new Courses(1, "jrtp",
		 * "Realtime project")); list.add(new Courses(2, "java", "core java"));
		 * list.add(new Courses(3, "phyton", "basic of phython"));
		 */
		
		
	}

	@Override
	public List<Courses> getcourse() {
		try {
			int a=0;
			throw new Exception("This is a test.");
		}catch (Exception e) {
			  Sentry.captureException(e);
		}
		return courseRepo.findAll();
	}

	@Override
	public Optional<Courses> getCourseById(Long courseId) {
		/*
		 * Courses c = null; for (Courses coursesById : list) { if (coursesById.getId()
		 * == courseId) { c = coursesById; break; }
		 * 
		 * 
		 * }
		 */
		return courseRepo.findById(courseId);
				
	}

	@Override
	public Courses addCourse(Courses courses) {
		//list.add(courses);
		courseRepo.save(courses);
		return courses;
	}

	@Override
	public Courses updateCourse(Courses courses) {
		/*
		 * list.forEach(e -> { if (e.getId() == courses.getId()) {
		 * 
		 * e.setTitle(courses.getTitle()); e.setDescription(courses.getDescription()); }
		 * });
		 */
		courseRepo.save(courses);
		
		return courses;
	}

	@Override
	public void deleteCourse(Long courseId) {
		/*
		 * for(Courses course:list) { if(course.getId()==courseId) {
		 * list.remove(courseId); break;
		 * 
		 * } }
		 */
		//list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Courses entity = courseRepo.getOne(courseId);
		courseRepo.delete(entity);
	}

	@Override
	public void updateCourseById(Long courseId) {
		Courses  co=courseRepo.findById(courseId).get();
		if(co.getId()!=0) {
			co.setId(co.getId());
			co.setDescription("full stack starting soon");
			co.setTitle("Full stack developer");
			courseRepo.save(co);
			
		}
		
	}

}
