package com.susanibar.david.footballapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProcessorException extends RuntimeException {
    private String message;
    private HttpStatus estado;
    private Throwable cause;
    private String traceid;
    private String application;
    private String version;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime fecha;

    public ProcessorException() {
        fecha = LocalDateTime.now();
    }

    public ProcessorException(Throwable cause, String message, HttpStatus estado) {
        this();
        this.message = message;
        this.estado = estado;
    }

    public ProcessorException(String message, HttpStatus estado) {
        this();
        this.message = message;
        this.estado = estado;
    }
}
