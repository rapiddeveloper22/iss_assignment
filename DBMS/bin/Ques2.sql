-- -- Create Database
-- CREATE DATABASE IF NOT EXISTS SampleDB;

-- -- Use Database
-- USE SampleDB;

-- Create Table with Constraints
CREATE TABLE IF NOT EXISTS Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Employees (
    EmployeeID INT AUTO_INCREMENT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    DepartmentID INT,
    Salary DECIMAL(10, 2),
    CONSTRAINT fk_department FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID),
    CHECK (Salary >= 0)
);

-- Insert Data
INSERT INTO Departments (DepartmentID, DepartmentName) VALUES
(1, 'IT'),
(2, 'Finance'),
(3, 'HR');

INSERT INTO Employees (FirstName, LastName, DepartmentID, Salary) VALUES
('John', 'Doe', 1, 60000.00),
('Jane', 'Smith', 2, 75000.00),
('Mike', 'Johnson', 1, 80000.00);

-- Select Data with Various Clauses
SELECT DISTINCT FirstName, LastName
FROM Employees
WHERE Salary > 70000.00 AND DepartmentID IN (1, 2) OR Salary < 60000.00
ORDER BY LastName DESC;

-- Update Data
UPDATE Employees SET Salary = 70000.00 WHERE EmployeeID = 1;

-- Delete Data (with SQL Injection Example)
DELETE FROM Employees WHERE EmployeeID = 3 OR 1=1; -- SQL Injection

-- Select Top N Records
SELECT FirstName, LastName
FROM Employees
LIMIT 2;

-- Like and Wildcards
SELECT FirstName, LastName
FROM Employees
WHERE LastName LIKE 'S%' OR FirstName LIKE '%a%';

-- In and Between
SELECT FirstName, LastName
FROM Employees
WHERE Salary BETWEEN 60000 AND 80000
AND DepartmentID IN (1, 2);

-- Aliases
SELECT E.FirstName AS EmpFirstName, D.DepartmentName AS DeptName
FROM Employees E
JOIN Departments D ON E.DepartmentID = D.DepartmentID;

-- Joins
SELECT E.FirstName, E.LastName, D.DepartmentName
FROM Employees E
JOIN Departments D ON E.DepartmentID = D.DepartmentID;

-- Inner Join
SELECT FirstName, LastName, DepartmentName
FROM Employees
INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;

-- Left Join
SELECT FirstName, LastName, DepartmentName
FROM Employees
LEFT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;

-- Right Join
SELECT FirstName, LastName, DepartmentName
FROM Employees
RIGHT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;

-- Full Join
SELECT E.FirstName, E.LastName, D.DepartmentName
FROM Employees E
LEFT JOIN Departments D ON E.DepartmentID = D.DepartmentID
UNION
SELECT E.FirstName, E.LastName, D.DepartmentName
FROM Employees E
RIGHT JOIN Departments D ON E.DepartmentID = D.DepartmentID;

-- Union
SELECT FirstName, LastName FROM Employees
UNION
SELECT FirstName, LastName FROM Employees;

-- Select Into
CREATE TABLE IF NOT EXISTS NewTable AS
SELECT FirstName, LastName
FROM Employees;

-- Insert Into Select
INSERT INTO NewTable (FirstName, LastName)
SELECT FirstName, LastName FROM Employees;

-- Create Index
CREATE INDEX idx_LastName ON Employees(LastName);

-- Alter Table
ALTER TABLE Employees
ADD COLUMN NewColumn INT;

-- Auto Increment, Default, Null Values
INSERT INTO Employees (FirstName, LastName) VALUES
('New', 'Person');

-- Views
CREATE VIEW HighSalaryView AS
SELECT FirstName, LastName
FROM Employees
WHERE Salary > 70000.00;

-- Group By, Having Functions, Null Functions
SELECT DepartmentID, COUNT(*) AS EmployeeCount, AVG(Salary) AS AvgSalary
FROM Employees
WHERE Salary IS NOT NULL
GROUP BY DepartmentID
HAVING COUNT(*) > 1;

-- Drop Table
DROP TABLE IF EXISTS Employees;
