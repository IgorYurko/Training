package iy.jspspring.training.util.validator.kernel;

public abstract class AbstractProjectValidatorErrors {
    private String fieldName;
    private Object invalidValue;
    private String message;

    public AbstractProjectValidatorErrors(String fieldName, Object invalidValue, String message) {
        this.fieldName = fieldName;
        this.invalidValue = invalidValue;
        this.message = message;
    }

    public AbstractProjectValidatorErrors() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
