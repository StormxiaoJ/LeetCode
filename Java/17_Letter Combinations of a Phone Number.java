class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        
        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        StringBuilder sb = new StringBuilder();
        helper(map,digits,sb,result);
        return result;
        
    }
    
    private void helper(Map<Character, char[]> map, String digits, StringBuilder sb, ArrayList<String> result){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        for(char c: map.get(digits.charAt(sb.length()))){
            sb.append(c);
            helper(map,digits,sb,result);
            //第一个字母开头的组合达到总长度之后，会回删一个，然后再加一个 eg：ad->a->af
            //执行完一套helper之后delete一次
            sb.deleteCharAt(sb.length()-1);
        }
    }
}