package com.eshop.douyin.print;



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrintRequest {
    @NotBlank
    private String cmd;

    @NotBlank
    private String requestID;

    @NotBlank
    private String version;

    @NotNull
    @Valid
    private Task task;
}