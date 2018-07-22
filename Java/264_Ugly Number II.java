class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> pqueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        Long[] prime = new Long[3];
        
        prime[0] = Long.valueOf(2);
        prime[1] = Long.valueOf(3);
        prime[2] = Long.valueOf(5);
        for(int i = 0 ; i < 3 ; i++){
            pqueue.add(prime[i]);
            set.add(prime[i]);
        }
        Long number = Long.valueOf(1);
        for(int i = 1; i < n ; i++){
            number = pqueue.poll();
            
            for(int j = 0; j < 3 ; j++){
                if(!set.contains(prime[j]*number)){
                    pqueue.add(prime[j]*number);
                    set.add(prime[j]*number);
                }
            }
        }
        return number.intValue();          
    }
}