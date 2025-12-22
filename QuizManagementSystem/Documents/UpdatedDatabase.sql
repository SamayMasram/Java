DROP DATABASE quiz_management_system;

CREATE DATABASE quiz_management_system;

USE quiz_management_system;

CREATE TABLE users(
    user_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE,
    password_hash VARCHAR(255),
    role ENUM('Admin' , 'Student') DEFAULT 'Student',
    created_at TIMESTAMP
);

CREATE TABLE quizzes(
    quiz_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    creator_id INT,
    created_at TIMESTAMP
);

CREATE TABLE questions(
    question_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quiz_id INT , FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE,
    question_text TEXT,
    option_a VARCHAR(500),
    option_b VARCHAR(500),
    option_c VARCHAR(500),
    option_d VARCHAR(500),
    correct_option CHAR(1),
    created_at TIMESTAMP
);

CREATE TABLE quiz_attempts(
    attempt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    quiz_id INT , FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE,
    user_id INT , FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    final_score INT,
    total_questions INT,
    created_at TIMESTAMP
);

DESC quiz_attempts;

DESC quizzes;

DESC questions;

DESC users;

