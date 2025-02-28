let students = JSON.parse(localStorage.getItem('students')) || [];

// Function to display students
function displayStudents(filteredStudents = students) {
    const studentTableBody = document.getElementById('student-table-body');
    studentTableBody.innerHTML = '';
    filteredStudents.forEach((student, index) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>
                <button class="edit-btn" data-index="${index}">Edit</button>
                <button class="delete-btn" data-index="${index}">Delete</button>
            </td>
        ;
        studentTableBody.appendChild(row);
    });
}

// Function to add student
function addStudent(name, email) {
    const newStudent = {
        id: students.length + 1,
        name,
        email
    };
    students.push(newStudent);
    localStorage.setItem('students', JSON.stringify(students));
    displayStudents();
}

// Function to edit student
function editStudent(index, name, email) {
    students[index].name = name;
    students[index].email = email;
    localStorage.setItem('students', JSON.stringify(students));
    displayStudents();
}

// Function to delete student
function deleteStudent(index) {
    students.splice(index, 1);
    localStorage.setItem('students', JSON.stringify(students));
    displayStudents();
}

// Load students from local storage on page load
document.addEventListener('DOMContentLoaded', displayStudents);

// Event listeners for adding students
document.getElementById('add-student-form').addEventListener('submit', (e) => {
    e.preventDefault();
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    addStudent(name, email);
    document.getElementById('add-student-form').reset();
});

// Event listeners for editing and deleting students
document.addEventListener('click', (e) => {
    if (e.target.classList.contains('edit-btn')) {
        const index = e.target.dataset.index;
        const name = prompt('Enter new name:', students[index].name);
        const email = prompt('Enter new email:', students[index].email);
        editStudent(index, name, email);
    } else if (e.target.classList.contains('delete-btn')) {
        const index = e.target.dataset.index;
        deleteStudent(index);
    }
});

// Event listener for search functionality
document.getElementById('search-input').addEventListener('input', (e) => {
    const query = e.target.value.toLowerCase();
    const filteredStudents = students.filter(student => 
        student.name.toLowerCase().includes(query) || 
        student.email.toLowerCase().includes(query)
    );
    displayStudents(filteredStudents);
});
