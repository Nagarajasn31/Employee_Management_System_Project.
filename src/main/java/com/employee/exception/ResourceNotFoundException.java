package com.employee.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3304134282143450910L;

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    // Default constructor.
    public ResourceNotFoundException() {
        super();
    }

    // Parameterized constructor to initialize exception with specific details.
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(); // Optionally, you can pass the error message to the superclass constructor.
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    // Getter for the resource name.
    public String getResourceName() {
        return resourceName;
    }

    // Getter for the field name.
    public String getFieldName() {
        return fieldName;
    }

    // Getter for the field value.
    public Object getFieldValue() {
        return fieldValue;
    }

    // Constructs an error message that describes the issue.
    public String getErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(resourceName)
          .append(" not found with ")
          .append(fieldName)
          .append(": '")
          .append(fieldValue)
          .append("'");
        return sb.toString();
    }
}
