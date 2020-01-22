package LeetCode.BFS.P126_Word_Ladder_II;
import java.util.*;

public class Solution {
    Map<String, Integer> distance;
    Set<String> dict;
    Map<String, Set<String>> graph;//存的是wordList中的某些String，以及与它相差1个字母的wordList中的String
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0)return res;
        //Initialize
        distance = new HashMap<>();
        distance.put(beginWord, 0);//Initialize, 初始化
        dict = new HashSet<>(wordList);//传入wordList进行初始化。HashSet dict用于O(1)内查找,同127 Word Ladder
        graph = new HashMap<>();
        //bfs+dfs. bfs其实可以不单独写。
        bfs(beginWord, endWord);
        List<String> list = new ArrayList<>();//这个list就是记录多个word路径的，需要传入dfs
        list.add(beginWord);//初始化list
        dfs(endWord, beginWord, list); //new ArrayList<>(Arrays.asList(beginWord))
        return res;
    }

    // step 1, 基于breath，广度优先,直到find end. 这一段和127 Word Ladder 做法相同。区别在于127找到一个就return，而这里需要遍历完到达end时同distance的情况
    public void bfs(String beginWord, String endWord) {
        Queue<String> queue = new LinkedList<>();//用于while循环遍历，同127 Word Ladder
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            char[] chars = cur.toCharArray();
            //cur的第1个for循环：try all possible substitution (26字母) in every position of current word, if newWord exists in dictionary, we add it to the adjacency list of cur
            for (int j = 0; j < chars.length; j++) { //for遍历cur的每一个字母，然后for循环依次替换成26个字母并搜索
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp=chars[j];
                    chars[j] = c;
                    String newWord = new String(chars);//newWord与原cur相差一个字母(若是cur在wordList内，newWord也可以为cur，但这个无影响)
                    if (dict.contains(newWord)) {
                        graph.putIfAbsent(cur, new HashSet<>());
                        graph.get(cur).add(newWord); //cur，以及wordList内的所有与cur相差一个字母的string
                    }
                    chars[j]=temp;
                }
            }
            //cur的第2个for循环： traverse all neighbors of current word, update distance and queue for next level
            for (String neighbor : graph.get(cur)) {
                if (!distance.containsKey(neighbor)) {//若distance含有neighbor,说明neighbor距离beginWord已经最小,不用再加入到distance中
                    distance.put(neighbor, distance.get(cur) + 1);
                    if (!neighbor.equals(endWord))queue.offer(neighbor);//放到里面,是为了借助if distance来排除一部分情况从而save time,若放到if distance条件外面，会TLE(Time Limit Exceeded)   //为什么endWord不放到queue中？因为endWord就是终点，不再需要加入queue中继续寻找了
                }
            }
        }
    }
    // step 2,需要返回多个List<String>,当然是深度优先。
    public void dfs(String endWord, String curWord, List<String> tempList) {
        if (curWord.equals(endWord)) {
            res.add(new ArrayList<>(tempList));//分配新的address
            return;
        }
        for (String nextWord : graph.get(curWord)) {
            if (distance.get(nextWord) == distance.get(curWord) + 1) {
                tempList.add(nextWord);
                dfs(endWord, nextWord, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}




























