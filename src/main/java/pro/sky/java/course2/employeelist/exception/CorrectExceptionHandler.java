package pro.sky.java.course2.employeelist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CorrectExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFoundException() {
        return new ResponseEntity<>("EmployeeNotFound", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> handleEmployeeAlreadyAddedException() {
        return new ResponseEntity<>("EmployeeAlreadyAdded", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmployeeStorageIsFullException.class)
    public ResponseEntity<String> handleEmployeeStorageIsFullException() {
        return new ResponseEntity<>("ArrayIsFull", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = BadNamingException.class)
    public ResponseEntity<String> handleBadNamingException() {
        return new ResponseEntity<>("Incorrect naming for employee", HttpStatus.BAD_REQUEST);
    }
}
