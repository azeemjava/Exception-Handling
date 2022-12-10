package in.triton.all.service;

import java.util.List;

import in.triton.all.api.response.ApiResponse;
import in.triton.all.entity.CourseStudent;
import in.triton.all.request.CourseRequest;
import in.triton.all.request.StudentRequest;
import in.triton.all.request.StudentSetCourseRequest;
import jakarta.validation.Valid;

public interface IStudentService {
	
	public ApiResponse saveAll(StudentRequest studentRequest)  ;

	public ApiResponse getAll();

	public ApiResponse getOne(int id);

	public ApiResponse update(@Valid StudentRequest studentRequest, int id);

	public ApiResponse delete(int id);

	public ApiResponse deleteAll();

	public ApiResponse saveAll(@Valid List<StudentSetCourseRequest>  studentSetCourseRequests,int id);


}
