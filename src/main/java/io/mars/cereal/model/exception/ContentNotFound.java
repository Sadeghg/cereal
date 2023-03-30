package io.mars.cereal.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ContentNotFound extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

}
