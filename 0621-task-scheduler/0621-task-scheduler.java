class Task implements Comparable<Task>{
    int freq;
    int executionTime;

    Task(int f, int t) {
        freq = f;
        executionTime = t;
    }

    public int compareTo(Task that) {
        return that.freq - this.freq;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char ch : tasks) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // insertion tasks in pq
        PriorityQueue<Task> pq = new PriorityQueue<>();
        // insert tasks in pq
        for(Character ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);
            pq.offer(new Task(freq, 0));
        }

        Queue<Task> queue = new LinkedList<>();
        int time = 0;

        while(!queue.isEmpty() || !pq.isEmpty()) {
            time++;
            // check if there is a task in pq 7 process it 

            if(!pq.isEmpty()) {
                Task task = pq.poll();
                task.freq--;
                if(task.freq > 0) {
                    // update the execution time 
                    task.executionTime = time + n;
                    queue.offer(task);
                }
            }
                // shift the active process to the pq
                if(!queue.isEmpty() && queue.peek().executionTime  == time) {
                    pq.offer(queue.poll());
                }
            
        }
        return time;
    }
}