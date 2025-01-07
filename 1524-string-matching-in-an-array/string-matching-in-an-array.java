public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0;  j < words.length; j++){
                if(i!=j){
                    if(words[i].contains(words[j])){
                        if(!res.contains(words[j])){
                            res.add(words[j]);
                        }
                    }
                }
            }
        }
        return res;
    }
}