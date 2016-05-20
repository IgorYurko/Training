package iy.jspspring.training.util.validator.kernel;

public interface ProjectBeansGenerator<T extends AbstractProjectValidatorErrors> {
    T generate();
}
