package iy.jspspring.training.util.validator.kernel;

public abstract class AbstractProjectBeansGenerator<T extends AbstractProjectValidatorErrors> implements ProjectBeansGenerator<T> {
    public AbstractProjectBeansGenerator() {
    }

    public abstract T generate();
}
