package com.logica.rh.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDateTime;

@Controller
public class ErrorHandler implements ErrorController {
    //Cette configuration n'est pas utilisé donc à supprimer
    /*@RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<APIException> handleError() {
        APIException exception = new APIException(HttpStatus.NOT_FOUND.getReasonPhrase(),
                HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }*/

}
