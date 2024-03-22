package edu.problems.leetcode_interview_crash_course_dsa.stacks_queues;

import java.util.Stack;

/**
 Given a string path, which is an absolute path (starting with a slash '/') to a file or directory
 in a Unix-style file system, convert it to the simplified canonical path.

 In a Unix-style file system, a period '.' refers to the current directory, a double period '..'
 refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated
 as a single slash '/'. For this problem, any other format of periods such as '...' are treated as
 file/directory names.

 The canonical path should have the following format:

 The path starts with a single slash '/'.
 Any two directories are separated by a single slash '/'.
 The path does not end with a trailing '/'.
 The path only contains the directories on the path from the root directory to the target file or
 directory (i.e., no period '.' or double period '..')

 Return the simplified canonical path.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");

        for (String dir: components) {
            if(dir.isBlank() || dir.equals(".")){
                continue;
            }else if (dir.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }else {
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir:stack) {
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
