

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leaderboard {

    public static List<String> getLeaderboard(List<String> scores) {
        return scores.stream()
                .flatMap(line -> {
                    String[] parts = line.split(" ");
                    StringBuilder nameBuilder = new StringBuilder();
                    List<Integer> scoreList = new ArrayList<>();

                    for (String part : parts) {
                        if (isNumeric(part)) {
                            scoreList.add(Integer.parseInt(part));
                        } else {
                            if (nameBuilder.length() > 0) {
                                nameBuilder.append(" ");
                            }
                            nameBuilder.append(part);
                        }
                    }

                    String name = nameBuilder.toString();
                    return scoreList.stream()
                            .map(score -> new AbstractMap.SimpleEntry<>(name, score));
                })
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.toList());
    }

    // Helper method to check if string is a number
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        List<String> scores = Arrays.asList("Abhishek 10 20 40 50", "Rishi 40 98 19 28");


        System.out.println(
            scores.stream().flatMap(line -> {
                    String[] parts = line.split(" ");
                    String name = parts[0];
                    return Arrays.stream(parts,  1, parts.length)
                                 .map(Integer::parseInt).map(score -> new AbstractMap.SimpleEntry<>(name, score));
                })
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .collect(Collectors.toList())
        );

        List<String> scoresNames = Arrays.asList(
            "10 20 Abhishek Kumar 40 50",
            "40 98 Rishi Verma 19 28"
    );
    List<String> leaderboard = getLeaderboard(scoresNames);
    leaderboard.forEach(System.out::println);
    }
}
