package com.eshop.douyin.print;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Document {
    @NotBlank
    private String docNo;

    private String documentID;

    private Integer copy = 1; // 默认1份

    @NotNull
    @Valid
    private List<Content> contents;
}
