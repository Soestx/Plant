package top.soest.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.soest.result.Result;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */

    @ExceptionHandler
    public Result exceptionHandler(Exception ex){

        log.error(ex.getMessage(), ex);
        return Result.error(ex.getMessage());
    }

    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String msg = ex.getMessage();
        if(msg.contains("Duplicate entry")){
            String[] split = msg.split(" ");
            String value = split[2].split("_")[0];
            return Result.error("该"+value+"已存在");
        }
        return Result.error(ex.getMessage());
    }



}
