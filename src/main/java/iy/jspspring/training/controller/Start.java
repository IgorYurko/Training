package iy.jspspring.training.controller;

import iy.jspspring.training.some.ClassWithBuilder;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start
{
    public static void main(String[] args)
    {
//        Object[] ls = Start.getReverseStringAndCountWord("Hello World!!!", 'w');

//        System.out.println(ls[0]);
//        System.out.println(ls[1]);
//        SomeGroovy someGroovy = new SomeGroovy();
        TestGroovy testGroovy = new TestGroovy();
        TestGroovy testGroovy1 = new TestGroovy();
        testGroovy.setName("Igor");
        testGroovy.setPassword("123");
        List<String> glist = new ArrayList<String>(){
            {
                add("Igor");
                add("Vasia");
                add("Sergey");
            }
        };

        System.out.println(testGroovy.reverseCollection(glist));
        System.out.println(testGroovy.getName() + " " + testGroovy.getPassword());
        String str = "https://www.google.com.ua/search";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.reverse();
        Pattern pattern = Pattern.compile("(https?|file).*+");

        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println(matcher.group(1));
        }

        System.out.println(count);
//        String group = matcher.group();

//        System.out.println(group);

//        if (matcher.matches()) System.out.println("Yes");
//
//        int count = 0;
//
//        while (matcher.find())
//        {
//            count++;
//        }
//
//        System.out.println(count);

//        String asdTr = WordUtils.capitalizeFully("asdTr");
//
//        System.out.println(asdTr);
//
//        File file = new File("/home/lord-777/file/test.txt");
//
//        if (file.isFile() && file.canRead() && file.canWrite())
//            try (
//                    BufferedInputStream inputStream = new BufferedInputStream(
//                            new FileInputStream(file)
//                    );
//                    BufferedOutputStream outputStream = new BufferedOutputStream(
//                            new FileOutputStream(file, true)
//                    )
//            )
//            {
//                while (fis.available() > 0)
//                {
//                    System.out.println((char) fis.read());
//                }
////
//                int length = inputStream.available();
//                inputStream.mark(length);
//
//                byte[] bytes = new byte[length];
//                if (inputStream.read(bytes) == length)
//                {
//                    System.out.println(new String(bytes));
//                    inputStream.reset();
//                }
//
//                outputStream.write(bytes, 0, inputStream.available());
//
//
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        else
//        {
//            System.out.println("No!!!");
//        }
//
//        Predicate<Integer> predicate = (e) -> e > 0;
//        Consumer<Object> println = (e) -> System.out.println(e.toString() + " ");
//
//        @SuppressWarnings("unchecked")
//        Consumer<Collection> printCollection = (e) -> e.forEach(
//                s -> System.out.print(s.toString() + " ")
//        );
//
//        Function<String, Integer> stringIntegerFunction = Integer::parseInt;
//
//        Consumer<String[]> printlnArray = (e) ->
//                Arrays.asList(e).forEach(System.out::println);
//
//        String[] strings = {"One", "Two",  "Three"};
//        printlnArray.accept(strings);
//
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("Igor");
        stringSet.add("Vasia");
        stringSet.add("Sasha");
        stringSet.add("Andrey");
        System.out.println(stringSet);
//        printCollection.accept(stringSet);
//
//        System.out.println("");
//
//        Set<String> stringSetRevers = new TreeSet<>(Comparators.stringReversComparator);
//        stringSetRevers.add("Igor");
//        stringSetRevers.add("Vasia");
//        stringSetRevers.add("Sasha");
//        stringSetRevers.add("Andrey");
//        printCollection.accept(stringSetRevers);
//
//        System.out.println("");
//
//        Set<Integer> integerSet = new TreeSet<>(Comparators.integerComparator);
//        integerSet.add(1);
//        integerSet.add(45);
//        integerSet.add(12);
//        integerSet.add(11111);
//        integerSet.add(133);
//        printCollection.accept(integerSet);
//
//        System.out.println("");
//
//        Set<Integer> integerReversSet = new TreeSet<>(Comparators.integerReversComparator);
//        integerReversSet.add(1);
//        integerReversSet.add(45);
//        integerReversSet.add(12);
//        integerReversSet.add(11111);
//        integerReversSet.add(133);
//        printCollection.accept(integerReversSet);
//
//        System.out.println("");
//
////        Set<UserPojo> userPojos = new TreeSet<>(Comparators.userPojoReversComparator);
////        userPojos.add(new UserPojo("Igor", "123"));
////        userPojos.add(new UserPojo("Vasia", "124"));
////        userPojos.add(new UserPojo("Vadim", "500"));
////        userPojos.add(new UserPojo("Sasha", "501"));
////        userPojos.add(new UserPojo("Gena", "1"));
////        userPojos.add(new UserPojo("Igor", "125"));
//
////        userPojos.forEach(e ->
////            System.out.println(e.getName() + " " + e.getPassword() + " ")
////        );
//
//        StringBuilder builder = new StringBuilder("Igor");
//        println.accept(builder.reverse());
//    }
//
//    public static Object[] getReverseStringAndCountWord(String s, Character c)
//    {
//        int len = s.length();
//        int index = len - 1;
//        int countWord = 0;
//        char[] arr = new char[len];
//
//        for (int i = index; i >= 0; i--)
//        {
//            char item = s.charAt(i);
//            if (c == item) countWord++;
//            arr[index - i] = item;
//        }
//
//        Object[] result = {new String(arr), countWord};
//
//        return result;

        Arrays.asList("A", "B", "Z", "C", "Y", "B").stream()
                .parallel()
                .unordered()
                .distinct()
                .sequential()
                .sorted((aObj, bObj) -> bObj.compareToIgnoreCase(aObj))
                .forEach(System.out::println);

        TestClass<String> testClass = new TestClass<>("Igor");
        String name = testClass.getName();
        name += " Best";
        System.out.println(name);
        System.out.println(testClass.getName());

        List<String> list = testClass.getList();
        list.add("Vasia");
        list.add("Igor");
        System.out.println(list);
        System.out.println(testClass.getList());

//        Integer age = testClass.getAge();
//        System.out.println(age);
//        System.out.println(testClass.getAge());

        System.out.println(TestClass.Temperature.FAHRENGATE.getTemperature());

        ClassWithBuilder.Builder builder = ClassWithBuilder.Builder.newBuilder();
        ClassWithBuilder build = builder.setAge("12").setName("Vasia").build();
        System.out.println(build);
    }
}
