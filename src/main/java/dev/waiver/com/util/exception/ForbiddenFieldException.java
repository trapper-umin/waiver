package dev.waiver.com.util.exception;


import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ForbiddenFieldException extends RuntimeException{

    List<String> forbiddenFields;
    public ForbiddenFieldException(List<String> forbiddenFields){
        this.forbiddenFields=forbiddenFields;
    }

}
