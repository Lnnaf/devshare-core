package com.lyn.devshare.dto;

import com.lyn.devshare.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBase {
    int code;
    ResponseStatus status;
    String msg;
    Object data;
    @Builder.Default
    Date time = new Date();

}
