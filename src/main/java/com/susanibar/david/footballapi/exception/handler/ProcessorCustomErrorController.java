package com.susanibar.david.footballapi.exception.handler;

import com.susanibar.david.footballapi.exception.ProcessorException;
import com.susanibar.david.footballapi.pojo.response.ProcessorImportResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ProcessorCustomErrorController implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorCustomErrorController.class);

    @Value("${football.codigo.aplicacion}")
    private String codigoAplicacion;

    @Value("${football.version.aplicacion}")
    private String version;

    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<Object> handleError(WebRequest webRequest, HttpServletResponse response) {
        ProcessorException processorException = new ProcessorException("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

        processorException.setVersion(version);
        processorException.setApplication(codigoAplicacion);
        processorException.setTraceid(MDC.get("X-B3-TraceId"));

        LOGGER.error(processorException.toString());

        return buildSimpleResponseEntity(
                processorException
        );
    }

    @Override
    public String getErrorPath() {
        return "/error";
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
