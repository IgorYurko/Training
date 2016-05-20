package iy.jspspring.training.util.validator.kernel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.*;
import java.util.stream.Collectors;

public class ProjectValidatorUtil {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ProjectValidatorUtil.class);
    protected static Validator validator;
    protected static ProjectBeansGenerator generator;
    private static final Builder builder = new Builder();

    protected ProjectValidatorUtil() {
    }

    protected ProjectValidatorUtil(Validator validator, ProjectBeansGenerator generator) {
        ProjectValidatorUtil.validator = validator;
        ProjectValidatorUtil.generator = generator;
    }

    protected void setValidator(Validator validator) {
        ProjectValidatorUtil.validator = validator;
    }

    protected void setGenerator(ProjectBeansGenerator generator) {
        ProjectValidatorUtil.generator = generator;
    }

    public static boolean isValid(Object obj)
    {
        return !isNull(obj) && getValidate(obj).size() == 0;
    }

    public static boolean isValid(Object obj, String field) {
        if (isNull(obj)) {
            return false;
        }
        if (isNull(field)) {
            return isValid(obj);
        }
        return getValidateProperty(obj, field).size() == 0;
    }

    public static boolean isValid(Object obj, String... fields) {
        return Arrays.stream(fields)
                .allMatch(e -> isValid(obj, e));
    }

    public static boolean isValid(Object... obj){
        return Arrays.stream(obj)
                .allMatch(e -> isValid(obj));
    }

    public static Map<String, AbstractProjectValidatorErrors> getNotValidFieldsAndErrors(Object obj) {
        if (isNull(obj) || isValid(obj)) {
            return Collections.emptyMap();
        }
        Set<ConstraintViolation<Object>> violations = getValidate(obj);
        HashMap<String, AbstractProjectValidatorErrors> result = new HashMap<>(violations.size());
        violations.stream()
                .peek(e -> LOGGER.info("Field: {}, message: {}.", e.getPropertyPath().toString(), e.getMessage()))
                .forEach(e -> {
                    String fieldName = e.getPropertyPath().toString();
                    if (result.containsKey(fieldName)) {
                        result.computeIfPresent(fieldName, (k, v) -> {
                            v.setMessage(v.getMessage() + " and " + e.getMessage());

                            return v;
                        });
                    } else {
                        AbstractProjectValidatorErrors errors = generator.generate();
                        errors.setFieldName(fieldName);
                        errors.setInvalidValue(e.getInvalidValue());
                        errors.setMessage(e.getMessage());
                        result.put(fieldName, errors);
                    }
                });

        return result;
    }

    public static List<String> getNotValidFields(Object obj) {
        if (isNull(obj) || isValid(obj))
            return Collections.emptyList();
        return getValidate(obj).stream()
                .map(e -> e.getPropertyPath().toString())
                .distinct()
                .peek(LOGGER::info)
                .collect(Collectors.toList());
    }

    protected static Set<ConstraintViolation<Object>> getValidate(Object obj) {
        return validator.validate(obj);
    }

    protected static Set<ConstraintViolation<Object>> getValidateProperty(Object obj, String field) {
        return ProjectValidatorUtil.validator.validateProperty(obj, field);
    }

    protected static boolean isNull(Object obj) {
        return obj == null;
    }

    public static Builder builder() {
        return builder;
    }

    public static class Builder {
        private Object obj;
        private final List<String> fields;

        private Builder() {
            this.fields = new ArrayList<>();
        }

        public Builder object(Object obj) {
            this.obj = obj;
            return this;
        }

        public Builder field(String field) {
            this.fields.add(field);
            return this;
        }

        public boolean isValid() {
            if (ProjectValidatorUtil.isNull(obj)) {
                clear();
                return false;
            }
            if (fields.size() == 0) {
                boolean is = ProjectValidatorUtil.isValid(obj);
                clear();
                return is;
            }
            boolean is = fields.stream()
                    .peek(LOGGER::info)
                    .allMatch(e -> ProjectValidatorUtil.isValid(obj, e));
            clear();
            return is;
        }

        private void clear() {
            obj = null;
            fields.clear();
        }
    }
}
