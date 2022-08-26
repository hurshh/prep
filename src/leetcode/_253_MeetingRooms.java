package leetcode;

import java.util.Arrays;

public class _253_MeetingRooms {
    public static void main(String[] args) {

    }

    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        if(intervals.length == 1) return 1;

        int lastEmpty = intervals[0][1], numberOfIntervals = intervals.length, lastIndex =0;
        int rooms = 1;

        for(int i=1;i< numberOfIntervals;i++){
            if(intervals[i][0] < lastEmpty){
                rooms++;
                if(intervals[i][1]< lastEmpty){
                    lastEmpty = intervals[i][1];
                    lastIndex = i;
                }
            }

            else {
                lastEmpty = intervals[i][1];
                lastIndex++;
            }
        }

        return rooms;
    }
}
