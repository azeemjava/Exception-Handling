package in.triton.all.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.triton.all.api.response.ApiResponse;
import in.triton.all.entity.Course;
import in.triton.all.entity.Department;
import in.triton.all.exception.ResourceAlreadyExists;
import in.triton.all.exception.ResourceNotFound;
import in.triton.all.mapping.CourseRequestMapper;
import in.triton.all.mapping.CourseResponseMapper;
import in.triton.all.repository.CourseRepository;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.DepartmentRequest;
import in.triton.all.response.CourseResponse;
import in.triton.all.response.DepartmentResponse;

@Service
public class CourseServiceImpl {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CourseRequestMapper courseRequestMapper;
	
	@Autowired
	CourseResponseMapper courseResponseMapper;
	

	public ApiResponse saveAll(CourseRequest courseRequest) throws ResourceAlreadyExists {
		List<Course> course = courseRequestMapper.modelToEntity(courseRequest);
		 course = courseRepository.saveAll(course);
		CourseResponse courseResponse = courseResponseMapper.entityToModel(course);
		ApiResponse apiResponse = new ApiResponse(courseResponse, null, "SUCCESSFULL", 201);
		return apiResponse;
	}


	public ApiResponse getAll() {
		List<Course> course= courseRepository.findAll();
		ApiResponse apiResponse = new ApiResponse(course, null, "SUCCESSFULL", 201);

		return apiResponse;
	}

	
	
}
