async function fetchEmployees() {
    const response = await fetch('/employees');
    const employees = await response.json();
    const employeeList = document.getElementById('employee-list');
    employeeList.innerHTML = '';

    employees.forEach(employee => {
        const div = document.createElement('div');
        div.textContent = employee.empName + ' (ID: ' + employee.empId + ', Salary: ' + employee.empSalary + ')';
        employeeList.appendChild(div);
    });
}

async function fetchStudents() {
    const response = await fetch('/students');
    const students = await response.json();
    const studentList = document.getElementById('student-list');
    studentList.innerHTML = '';

    students.forEach(student => {
        const div = document.createElement('div');
        div.textContent = student.studentName + ' (ID: ' + student.studentId + ', Marks: ' + student.studentMarks + ')';
        studentList.appendChild(div);
    });
}

// Handle form submission for adding an employee
document.getElementById('employee-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const empName = document.getElementById('empName').value;
    const empSalary = document.getElementById('empSalary').value;

    const response = await fetch('/employees', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ empName, empSalary })
    });

    if (response.ok) {
        fetchEmployees(); // Refresh the employee list
        document.getElementById('employee-form').reset(); // Clear input fields
    }
});

// Handle form submission for adding a student
document.getElementById('student-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const studentName = document.getElementById('studentName').value;
    const studentMarks = document.getElementById('studentMarks').value;

    const response = await fetch('/students', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ studentName, studentMarks })
    });

    if (response.ok) {
        fetchStudents(); // Refresh the student list
        document.getElementById('student-form').reset(); // Clear input fields
    }
});
