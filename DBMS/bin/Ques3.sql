USE emp;

DELIMITER //

CREATE PROCEDURE GetEmployeeDetails(IN employeeId INT)
BEGIN
    SELECT * FROM Employees WHERE EmployeeID = employeeId;
END //

DELIMITER ;
