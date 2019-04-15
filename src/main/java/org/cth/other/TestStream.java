package org.cth.other;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestStream {
    private static Logger log = LoggerFactory.getLogger(TestStream.class);
    /**
     * 过滤所有的男性
     */
    public static void filterSex() {
        List<PersonModel> data = Data.getData();
        log.info(">>>filterSex");
        //old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : data) {
            if ("男".equals(person.getSex())) {
                temp.add(person);
            }
        }
        log.info(JsonUtil.toStr(temp));
        //new
        List<PersonModel> collect = data
                .stream()
                .filter(person -> "男".equals(person.getSex()))
                .collect(toList());
        log.info(JsonUtil.toStr(collect));
    }

    /**
     * 过滤所有的男性 并且小于20岁
     */
    public static void filterSexAndAge() {
        List<PersonModel> data = Data.getData();
        log.info(">>>filterSexAndAge");
        //old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : data) {
            if ("男".equals(person.getSex()) && person.getAge() < 20) {
                temp.add(person);
            }
        }
        log.info(JsonUtil.toStr(temp));
        //new 1
        List<PersonModel> collect = data
                .stream()
                .filter(person -> {
                    if ("男".equals(person.getSex()) && person.getAge() < 20) {
                        return true;
                    }
                    return false;
                })
                .collect(toList());
        //new 2
        List<PersonModel> collect1 = data
                .stream()
                .filter(person -> ("男".equals(person.getSex()) && person.getAge() < 20))
                .collect(toList());
        log.info(JsonUtil.toStr(collect));
    }

    /**
     * 取出所有的用户名字
     */
    public static void getUserNameList(){
        List<PersonModel> data = Data.getData();
        log.info(">>>getUserNameList");
        //old
        List<String> list=new ArrayList<>();
        for (PersonModel person:data) {
            list.add(person.getName());
        }
        log.info(JsonUtil.toStr(list));

        //new 1
        List<String> collect = data.stream().map(person -> person.getName()).collect(toList());
        log.info(JsonUtil.toStr(collect));

        //new 2
        List<String> collect1 = data.stream().map(PersonModel::getName).collect(toList());
        log.info(JsonUtil.toStr(collect1));

        //new 3
        List<String> collect2 = data.stream().map(person -> {
            return person.getName();
        }).collect(toList());
        log.info(JsonUtil.toStr(collect2));
    }

    public static void flatMapString() {
        List<PersonModel> data = Data.getData();
        log.info(">>>flatMapString");
        //返回类型不一样
        List<String> collect = data.stream()
                .flatMap(person -> Arrays.stream(person.getName().split(" "))).collect(toList());
        log.info(JsonUtil.toStr(collect));

        List<Stream<String>> collect1 = data.stream()
                .map(person -> Arrays.stream(person.getName().split(" "))).collect(toList());
        log.info(JsonUtil.toStr(collect1));

        //用map实现
        List<String> collect2 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream).collect(toList());
        log.info(JsonUtil.toStr(collect2));

        //另一种方式
        List<String> collect3 = data.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(toList());
        log.info(JsonUtil.toStr(collect3));
    }

    public static void reduceTest(){
        log.info(">>>reduceTest");
        //累加，初始化值是 10
        Integer reduce = Stream.of(1, 2, 3, 4)
                .reduce(10, (count, item) ->{
                    return count + item;
                } );
        log.info(">>>" + reduce);

        Integer reduce1 = Stream.of(1, 2, 3, 4)
                .reduce(0, (x, y) -> x + y);
        log.info(">>>" + reduce1);

        String reduce2 = Stream.of("1", "2", "3")
                .reduce("0", (x, y) -> (x + "," + y));
        log.info(">>>" + reduce2);
    }

    /**
     * toList
     */
    public static void toListTest(){
        log.info(">>>toListTest");
        List<PersonModel> data = Data.getData();
        List<String> collect = data.stream()
                .map(PersonModel::getName)// person -> person.getName();
                .collect(Collectors.toList());
        log.info(">>>" + JsonUtil.toStr(collect));
    }

    /**
     * toSet
     */
    public static void toSetTest(){
        log.info(">>>toSetTest");
        List<PersonModel> data = Data.getData();
        Set<String> collect = data.stream()
                .map(PersonModel::getName)
                .collect(Collectors.toSet());
        log.info(">>>" + JsonUtil.toStr(collect));
    }

    /**
     * toMap
     */
    public static void toMapTest(){
        log.info(">>>toMapTest");
        List<PersonModel> data = Data.getData();
        Map<String, Integer> collect = data.stream()
                .collect(
                        Collectors.toMap(PersonModel::getName, PersonModel::getAge)
                );
        log.info(">>>" + JsonUtil.toStr(collect));
        data.stream()
                .collect(Collectors.toMap(per->per.getName(), value->{
                    return value+"1";
                }));
        log.info(">>>" + JsonUtil.toStr(data));
    }

    /**
     * 指定类型
     */
    public static void toTreeSetTest(){
        log.info(">>>toTreeSetTest");
        List<PersonModel> data = Data.getData();
        TreeSet<String> collect = data.stream().map(s -> s.getName())
                .collect(Collectors.toCollection(TreeSet::new));//() -> new TreeSet<>();
        log.info(">>>" + JsonUtil.toStr(collect));
    }

    /**
     * 分组
     */
    public static void toGroupTest(){
        log.info(">>>toGroupTest");
        List<PersonModel> data = Data.getData();
        Map<Boolean, List<PersonModel>> collect = data.stream()
                .collect(Collectors.groupingBy(per -> "男".equals(per.getSex())));
        log.info(">>>" + JsonUtil.toStr(collect));
    }

    /**
     * 分隔
     */
    public static void toJoiningTest(){
        log.info(">>>toJoiningTest");
        List<PersonModel> data = Data.getData();
        String collect = data.stream()
                .map(personModel -> personModel.getName())
                .collect(Collectors.joining(",", "{", "}"));
        log.info(">>>" + JsonUtil.toStr(collect));
        Set<String> a = new HashSet<>();
        a.add("111");
        a.add("112");
        a.add("113");

    }

    /**
     * 自定义
     */
    public static void reduce(){
        log.info(">>>reduce");
        List<String> collect = Stream.of("1", "2", "3").collect(
                Collectors.reducing(new ArrayList<String>(), arg -> Arrays.asList(arg), (newArr, ArrList) -> {
                    newArr.addAll(ArrList);
                    return newArr;
                }));
        log.info(">>>" + JsonUtil.toStr(collect));

        List<String> a = new ArrayList<>();
        List<String> b = Arrays.asList("1", "2", "3");
//        int[] c = {1,2,3};
        a.addAll(b);
        log.info(">>>" + JsonUtil.toStr(a));
    }

}
