package org.cth.other;

import java.util.stream.Stream;

public class Apsara {
    /**
     * ali 云栖 java8 stream
     */
    public static void main(String[] args) {
        Stream.of("Apsara","2019","9.25-9.27","Digital Economy")
        .map(x->57 == x.charAt(0)?"Here is the": 50==x.charAt(0)?x.concat(":"):x)
        .reduce((x,y)->x+" "+y)
        .ifPresent(System.out::print);
    }
}
