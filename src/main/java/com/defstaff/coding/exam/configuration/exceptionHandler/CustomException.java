package com.defstaff.coding.exam.configuration.exceptionHandler;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private String errorCode;

  public CustomException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public CustomException(String message) {
    super(message);
  }

}