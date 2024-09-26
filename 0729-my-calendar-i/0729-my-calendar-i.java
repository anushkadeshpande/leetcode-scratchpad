class MyCalendar {
    List<List<Integer>> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i=0; i<events.size(); i++) {
            int s = events.get(i).get(0);
            int e = events.get(i).get(1);
            
            if(start < e && end > s) {
                return false;
            }
        }
        events.add(Arrays.asList(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */