package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _210_CourseSchedule2 {
    public static void main(String[] args) {
        int[] eg = findOrder(2, new int[][]{{1,0}});

        for(int i: eg) System.out.print(i + " ");
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(!canFinish(numCourses, prerequisites)) return  new int[]{};

        ArrayList<ArrayList<Integer>> courses = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for(int i=0; i<prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        return topSort(numCourses, courses);

    }

    public static void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> ans){
        visited[curr] = true;

        for(int i : graph.get(curr)){
            if(!visited[i])dfs(i, visited, graph, ans);
        }

        ans.add(curr);
    }

    public static int[] topSort(int nodes, ArrayList<ArrayList<Integer>> graph){
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[nodes];

        for(int i=0;i< nodes;i++){
            if(!visited[i]){
                dfs(i,visited, graph, answer);
            }
        }

        Collections.sort(answer);

        int[] ans = new int[answer.size()];

        for(int i=0;i< answer.size();i++) ans[i] = answer.get(i);
        return ans;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i=0; i<numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for(int i=0; i<prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // dfs visit each course
        for(int i=0; i<numCourses; i++) {
            if (!dfs(i,courses, visited)) return false;
        }

        return true;
    }

    private static boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        visited[course] = 1; // mark it being visited

        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for(int i=0; i<eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i);

            if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if(visited[eligibleCourse]  == 0) { // not visited
                if (!dfs(eligibleCourse,courses, visited)) return false;
            }

        }

        visited[course] = 2; // mark it done visiting
        return true;

    }
}
