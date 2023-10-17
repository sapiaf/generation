# Soluzioni `GROUP BY`

1. Contare quanti iscritti ci sono stati ogni anno
```SQL
SELECT YEAR(enrolment_date), COUNT(*) AS 'Number of Students'
FROM students
GROUP BY YEAR(enrolment_date);
```
2. Contare gli insegnanti che hanno l'ufficio nello stesso edificio
```SQL
SELECT office_address, COUNT(*) AS 'Number of Teachers'
FROM teachers 
GROUP BY office_address;
```
3. Calcolare la media dei voti di ogni appello d'esame
```SQL
SELECT exam_id, AVG(vote) AS 'Average Score'
FROM exam_student
GROUP BY exam_id;
```
4. Contare quanti corsi di laurea ci sono per ogni dipartimento
```SQL
SELECT department_id, departments.name, COUNT(*) AS 'Number of Courses'
FROM degrees
JOIN departments ON degrees.department_id = departments.id
GROUP BY department_id, departments.name;
```

# Soluzioni `JOIN`
1. Selezionare tutti gli studenti iscritti al Corso di Laurea in Economia
```SQL
SELECT *
FROM students
JOIN degrees ON students.degree_id = degrees.id
WHERE degrees.name = 'Corso di Laurea in Economia';
```
2. Selezionare tutti i Corsi di Laurea Magistrale del Dipartimento di Neuroscienze
```SQL
SELECT degrees.id, degrees.name, degrees.level, departments.name AS department_name
FROM degrees
JOIN departments ON degrees.department_id = departments.id
WHERE departments.name = 'Dipartimento di Neuroscienze' AND degrees.level = 'Magistrale';
```
3. Selezionare tutti i corsi in cui insegna Fulvio Amato (id=44)
```SQL
SELECT DISTINCT degrees.*
FROM degrees
JOIN courses ON degrees.id = courses.degree_id
JOIN course_teacher ON courses.id = course_teacher.course_id
WHERE course_teacher.teacher_id = 44;
```
4. Selezionare tutti gli studenti con i dati relativi al corso di laurea a cui sono iscritti e il  relativo dipartimento, in ordine alfabetico per cognome e nome
```SQL
SELECT students.*, degrees.name AS degree_name, departments.name AS department_name
FROM students
JOIN degrees ON students.degree_id = degrees.id
JOIN departments ON degrees.department_id = departments.id
ORDER BY students.surname, students.name;
```
5. Selezionare tutti i corsi di laurea con i relativi corsi e insegnanti
```SQL
SELECT
	degrees.name,
	courses.name,
	teachers.name,
	teachers.surname
FROM degrees
JOIN courses ON degrees.id = courses.degree_id
JOIN course_teacher ON courses.id = course_teacher.course_id
JOIN teachers ON course_teacher.teacher_id = teachers.id;
```
6. Selezionare tutti i docenti che insegnano nel Dipartimento di Matematica (54)
```SQL
SELECT DISTINCT teachers.*
FROM teachers
JOIN course_teacher ON teachers.id = course_teacher.teacher_id
JOIN courses ON course_teacher.course_id = courses.id
JOIN degrees ON courses.degree_id = degrees.id
JOIN departments ON degrees.department_id = departments.id
WHERE departments.name = 'Dipartimento di Matematica';
```
7. BONUS: Selezionare per ogni studente quanti tentativi d’esame ha sostenuto per superare ciascuno dei suoi esami.
```SQL
SELECT
	exam_student.student_id,
	students.name,
	students.surname,
	exam_student.exam_id,
	COUNT(*) AS 'Number of Attempts'
FROM exam_student
JOIN students ON exam_student.student_id = students.id
GROUP BY exam_student.student_id, exam_student.exam_id;
```