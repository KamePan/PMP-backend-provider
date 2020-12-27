package cn.edu.ecnu.domain;

import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "")
public class Attachment implements Serializable {

    private String aid;

    private String path;

    private String pid;

    private static final long serialVersionUID = 1L;

}