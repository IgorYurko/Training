package iy.jspspring.training.some;

public class ClassWithBuilder
{
    private final String name;

    private final String age;

    private ClassWithBuilder(Builder builder)
    {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName()
    {
        return name;
    }

    public String getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return getName() + " - " + getAge();
    }

    public static class Builder
    {
        private String name = "Igor";

        private String age = "31";

        private Builder()
        {
        }

        public static Builder newBuilder()
        {
            return new Builder();
        }

        public Builder setName(String name)
        {
            this.name = name;

            return this;
        }

        public Builder setAge(String age)
        {
            this.age = age;

            return this;
        }

        public ClassWithBuilder build()
        {
            return new ClassWithBuilder(this);
        }
    }
}

