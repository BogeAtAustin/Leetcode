package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _127WordLadder {

    //BFS 与279套路类似，Queue存入相邻节点（每道题对相邻节点的定义不同），set都是相同的作用，避免绕弯/loop，这样确保shortest path

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord) == -1){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int res = 0;
        queue.offer(beginWord);

        while(!queue.isEmpty()){
            res++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                if(curr.equals(endWord)){
                    return res;
                }
                for(String word : wordList){
                    if(!set.contains(word)){
                        if(isOneLetterDiff(word, curr)){
                            queue.offer(word);
                            set.add(word);
                        }
                    }
                }
            }

        }
        return 0;
    }
    private boolean isOneLetterDiff(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
