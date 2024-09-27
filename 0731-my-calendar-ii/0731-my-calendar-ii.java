class MyCalendarTwo {
    List<Pair> events;
    List<Pair> overlaps;
    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
    for (Pair overlap : overlaps) {
        if (Math.max(start, overlap.start) < Math.min(end, overlap.end)) {
            return false;
        }
    }
    for (Pair event : events) {

        if (Math.max(start, event.start) < Math.min(end, event.end)) {
            overlaps.add(new Pair(Math.max(start, event.start), Math.min(end, event.end)));
        }
    }
    events.add(new Pair(start, end));
    return true;
}
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */