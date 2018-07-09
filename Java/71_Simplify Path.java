class Solution {
    public String simplifyPath(String path) {
        String res = "/";
        String[] sub = path.split("/+");
        ArrayList<String> paths = new ArrayList<>();
        for(String s : sub){
            if(s.equals("..")){
                if(paths.size()>0){
                    paths.remove(paths.size()-1);
                }
            } else if (!s.equals(".") == !s.equals("")){
                paths.add(s);
            }
        }
        for(String s : paths){
            res+=s+"/";
        }
        if(res.length()>1){
            res = res.substring(0,res.length()-1);
        }
        return res;
    }
}