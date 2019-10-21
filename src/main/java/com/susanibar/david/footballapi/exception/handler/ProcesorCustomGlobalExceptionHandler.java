package com.susanibar.david.footballapi.exception.handler;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.pojo.response.ProcessorImportResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ProcesorCustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcesorCustomGlobalExceptionHandler.class);

    @Value("${football.codigo.aplicacion}")
    private String codigoAplicacion;

    @Value("${football.version.aplicacion}")
    private String version;

    @ExceptionHandler(ProcessorException.class)
    public ResponseEntity<Object> handleApiErrorException(ProcessorException processorException) {
        processorException.setVersion(version);
        processorException.setApplication(codigoAplicacion);
        processorException.setTraceid(MDC.get("X-B3-TraceId"));

        LOGGER.error(processorException.toString());

        return buildSimpleResponseEntity(
                 processorException
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(HttpServletRequest request, Exception e) {
        ProcessorException processorException = new ProcessorException("Server Error", HttpStatus.GATEWAY_TIMEOUT);

        processorException.setVersion(version);
        processorException.setApplication(codigoAplicacion);
        processorException.setTraceid(MDC.get("X-B3-TraceId"));

        LOGGER.error(processorException.toString());

        return buildSimpleResponseEntity(
                processorException
        );
    }

    private ResponseEntity<Object> buildSimpleResponseEntity(ProcessorException processorException) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("trace-id", processorException.getTraceid());

        return new ResponseEntity<>(
                new ProcessorImportResponse(
                        processorException.getMessage()
                ),
                headers,
                processorException.getEstado()
        );
    }
}
