package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    
    public static void show(){ //Streams operation are 2 categories, itermediate (filter,map,limit) and terminal(forEach,count)
                                //A terminal is expected in order to obtain something out of a stream.
        List<Movies> movies = List.of(
            new Movies("a",10, Genre.THRILLER),
            new Movies("b",20, Genre.ACTION),
            new Movies("c",30,Genre.COMEDY)
        );

        //filtering
        var countMovies = movies.stream() 
                                .filter(movie -> movie.getLikes() > 10)
                                .count();
        System.out.println(countMovies);

        //Streamables
        Collection<Integer> coll;
        //coll.stream();

        var list = new ArrayList<String>();
        list.stream();

        int[] numbers = {1,2,3};
        Arrays.stream(numbers).forEach(n -> System.out.println(n));

        //Create Streams
        Stream.of(1,2,3,4,5);

        var stream = Stream.generate(() -> Math.random());
        stream.limit(10).forEach(n -> System.out.println(n));

        Stream.iterate(1, n -> n+1).limit(10).forEach(n -> System.out.println(n));

        //MAP
        movies.stream()
              .map(movie -> movie.getTitles()).forEach(name -> System.out.println(name));

        var stream2 = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream2.flatMap(listvar -> listvar.stream()) // Stream<List<x>> --> Stream<x>
               .forEach(n -> System.out.println(n));

        //Slicing
        movies.stream()
              .skip(1)
              .limit(1)
              .forEach(movie -> System.out.println(movie.getTitles()));

        movies.stream()
              .takeWhile(m -> m.getLikes() < 30)
              .forEach(movie -> System.out.println(movie.getTitles()));

        //Sorting
        movies.stream() //.sorted((a,b) -> a.getTitles().compareTo(b.getTitles()))
              .sorted(Comparator.comparing(Movies::getTitles).reversed()) //m -> m.getTitles())
              .forEach(movie -> System.out.println(movie.getTitles()));

        //Getting Unique Values
        movies.stream()
              .map(Movies::getLikes)
              .distinct()
              .forEach(System.out::println);

        //Peeking
        movies.stream()
              .filter(m -> m.getLikes()>10)
              .peek(m -> System.out.println("Filtered: " +m.getTitles()))
              .map(Movies::getTitles)
              .peek(t -> System.out.println("mapped: " +t))
              .forEach(System.out::println);

        // Primite reducers of streams
        var result2 = movies.stream()
                            .anyMatch(movie -> movie.getLikes() > 10); // allMatch -> all satisfy condition, noneMatch -> none satisfy
        System.out.println(result2);

        var result3 = movies.stream()
                            .findFirst()
                            .get();
        System.out.println(result3.getTitles());

        var result4 = movies.stream()
                            .max(Comparator.comparing(Movies::getLikes))
                            .get();
        System.out.println(result4.getTitles());

        //Reducers
        Optional<Integer> sum = movies.stream()
                                      .map(Movies::getLikes)
                                      .reduce(Integer::sum); //(a,b) -> a+b
        System.out.println(sum.orElse(0));

        //Collectors
        var result5 = movies.stream()
                            .filter(m -> m.getLikes() > 10)
                            .collect(Collectors.toList());
        System.out.println(result5);

        var result6 = movies.stream()
                            .filter(m -> m.getLikes() > 10)
                            .collect(Collectors.toMap(Movies::getTitles,Function.identity())); // m -> m
        System.out.println(result6);
    
        var result7 = movies.stream()
                            .filter(m -> m.getLikes() > 10)
                            .collect(Collectors.summingInt(Movies::getLikes)); // m -> m
        System.out.println(result7);

        var result8 = movies.stream()
                            .filter(m -> m.getLikes() > 10)
                            .collect(Collectors.summarizingInt(Movies::getLikes)); // m -> m
        System.out.println(result8);

        var result9 = movies.stream()
                            .filter(m -> m.getLikes() > 10)
                            .map(Movies::getTitles)
                            .collect(Collectors.joining(",")); // m -> m
        System.out.println(result9);

        // Grouping  

        var result10 = movies.stream()
                             .collect(Collectors.groupingBy(
                                        Movies::getGenre, 
                                        Collectors.mapping(
                                            Movies::getTitles,
                                            Collectors.joining(",")
                                        )));
        System.out.println(result10);

        //Partitioning

        var result11 = movies.stream()
                             .collect(Collectors.partitioningBy(
                                 m -> m.getLikes()>20,
                                 Collectors.mapping(
                                     Movies::getTitles,
                                     Collectors.joining(",")
                                      )));

        // Primitive Streams
        IntStream.rangeClosed(1, 5).forEach(System.out::println);;
    }
    
}
