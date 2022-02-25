package studentinfo;

import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;


@ControllerAdvice
public class Exception
	{
	    private static final Logger log = LoggerFactory.getLogger(Exception.class);
	    
	    @ExceptionHandler(JsonProcessingException.class)
	    public ResponseEntity<ErrorDetails> jsonExcpetionHandler(JsonProcessingException ex,WebRequest request) {
	        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        log.error("Occurred Exception {}", errorDetails);
	        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	    }
	 

}
