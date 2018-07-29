public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            edges[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            //该门课有哪些后置课
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < degree.length ; i++){
            if(degree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            int n = edges[course].size();
            //它是哪些课的前置
            for(int i = 0 ; i < n ; i++){
                int pointer = (int)edges[course].get(i);
                //pointer为course的一门后置课
                //因为学了course，所以degree【后置课】--
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.offer(pointer);
                }
            }
        }
        return count == numCourses;
    }
}