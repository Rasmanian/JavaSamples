import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
  
/* PROBLEM IS TO MERGE MEETINGS to find the times when everyone is free. Meetings can over lap as they can be 
  between different groups spearately at the same time; The meetings list may not be sorted when given as input;
*/
  
public class Meeting {

    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public String toString() {
        return String.format("(%d, %d)", startTime, endTime);
    }
      
      
    /* SORTING THE MEETING IS THE KEY AND is O(nlogn) time. Then we loop once to merge the sorted entries
      which again is O(n). So in total, the worst case is the bigger of the two, which is O(nlogn) [this is still better
      than TWO loops]
      SPACE complexity is O(n) worst case as we have to create a new list of the same size in the worst case.
    */
    
    public static List<Meeting> mergeRanges(List<Meeting> meetings) 
    {
        // sort by start times USING AN ANONYMOUS COMPARATOR
        List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2)  {
                return m1.startTime - m2.startTime; // Return an Integer value.
            }
        });

        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current and last meetings overlap, use the latest end time
            if (currentMeeting.startTime <= lastMergedMeeting.endTime) {
                lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);

            // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

}
