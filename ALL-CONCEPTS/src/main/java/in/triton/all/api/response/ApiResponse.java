package in.triton.all.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class ApiResponse {

	public ApiResponse(Object data, String error, Object status, long code) {
		super();
		this.data = data;
		this.error = error;
		this.status = status;
		this.code = code;
	}
	private Object data;
	private String error;
	private Object status;
	private long code;
	
}
