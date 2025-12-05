package com.eshop.douyin.print;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Task {
    @NotBlank
    private String taskID;

    @NotBlank
    private String printer;

    private boolean preview;

    private String config;

    @NotNull
    @Valid
    private List<Document> documents;
}