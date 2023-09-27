package com.mathsena.timetodo.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  private Long timestamp;
  private Integer status;
  private String message;
}
