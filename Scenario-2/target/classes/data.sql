-- Insert Students
INSERT INTO Student (name, email, enrollment_date) VALUES
('Alice Johnson', 'alice@example.com', '2024-02-01'),
('Bob Smith', 'bob@example.com', '2024-02-02'),
('Charlie Brown', 'charlie@example.com', '2024-02-03');

-- Insert Courses
INSERT INTO Course (title, description, duration) VALUES
('Java Spring Boot', 'Learn Spring Boot for enterprise applications', '6 weeks'),
('ReactJS Development', 'Build dynamic web applications using React', '8 weeks'),
('Data Science with Python', 'Machine learning and data science concepts', '10 weeks');


-- Assign Students to Courses
INSERT INTO STUDENT_COURSE_TABLE (student_id, course_id) VALUES
(1, 1), -- Alice enrolled in Java Spring Boot
(1, 2), -- Alice enrolled in ReactJS
(2, 1), -- Bob enrolled in Java Spring Boot
(2, 3), -- Bob enrolled in Data Science
(3, 1), -- Charlie enrolled Java Spring Boot
(3, 3); -- Charlie enrolled in Data Science
