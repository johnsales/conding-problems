package edu.problems;

public class SchedulingErrors {

    /**

     SELECT DISTINCT p.name AS professor_name, c.name AS course_name
     FROM professor p
     JOIN schedule s ON s.professor_id = p.id
     JOIN course c ON s.course_id = c.id
     WHERE c.department_id <> p.department_id;

     */


}
