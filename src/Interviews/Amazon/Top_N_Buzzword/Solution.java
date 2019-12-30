package Interviews.Amazon.Top_N_Buzzword;
//
//You work on a team whose job is to understand the most sought after toys for the holiday season.
//        A teammate of yours has built a webcrawler that extracts a list of quotes about toys from
//        different articles. You need to take these quotes and identify which toys are mentioned
//        most frequently. Write an algorithm that identifies the top N toys out of a list of
//        quotes and list of toys.
//
//        Your algorithm should output the top N toys mentioned most frequently in the quotes.

//Input:
//        The input to the function/method consists of five arguments:
//
//        numToys, an integer representing the number of toys
//        topToys, an integer representing the number of top toys your algorithm needs to return;
//        toys, a list of strings representing the toys,
//        numQuotes, an integer representing the number of quotes about toys;
//        quotes, a list of strings that consists of space-sperated words representing articles about
//        toys
//
//        Output:
//        Return a list of strings of the most popular N toys in order of most to least frequently
//        mentioned
//
//        Note:
//        The comparison of strings is case-insensitive. If the value of topToys is more than the
//        number of toys, return the names of only the toys mentioned in the quotes. If toys
//        are mentioned an equal number of times in quotes, sort alphabetically.

//Input:
//        numToys = 6
//        topToys = 2
//        toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
//        numQuotes = 6
//        quotes = [
//        "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
//        "The new Elmo dolls are super high quality",
//        "Expect the Elsa dolls to be very popular this year, Elsa!",
//        "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
//        "For parents of older kids, look into buying them a drone",
//        "Warcraft is slowly rising in popularity ahead of the holiday season"
//        ];
//
//        Output:
//        ["elmo", "elsa"]
//
//        Explanation:
//        elmo - 4
//        elsa - 4
//        "elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa"
//        appears in 2 different quotes.
import java.util.*;
public class Solution {
    public List<String> returnTopToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        List<String> res = new ArrayList<>();
        if(numToys==0||numQuotes==0) return res;
        Map<String, Integer> map = new HashMap<>();
        for(String toy: toys) {
            map.put(toy, 0);
        }

        for(String quote: quotes) {
            String[] list = quote.split(" ");
            for(String e: list) {
                if(e!=null||e.length()>0) {
                    String wordInLowerCase = e.toLowerCase();
                    if(map.containsKey(wordInLowerCase)) {
                        map.put(wordInLowerCase, map.get(wordInLowerCase)+1);
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> entryList= new ArrayList<>(map.entrySet());

        Collections.sort(entryList, (a, b) -> (b.getValue() - a.getValue()) != 0 ? (b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()));
        int i = 0;
        while (i < entryList.size() && topToys > 0) {
            topToys--;
            res.add(entryList.get(i).getKey());
            i++;
        }

        return res;

    }
}

