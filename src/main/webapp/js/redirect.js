function redirectToLogin() {
	
            const roleSelect = document.getElementById('role-select');
            const selectedRole = roleSelect.value;

            // Redirect based on selected role
            if (selectedRole) {
                const loginPages = {
                    admin: 'login.jsp', // Change this to your actual admin login page
                    payroll: 'payrollLogin.jsp', // Change to your actual payroll login page
                    hr: 'HRLogin.jsp', // Change to your actual HR login page
                    it: 'ITLogin.jsp' // Change to your actual IT login page
                };

                // Redirect to the selected role's login page
                window.location.href = loginPages[selectedRole];
            }
        }
function validateForm() {
            // Get form values
            var email = document.getElementById("email").value;
            var phone = document.getElementById("phone").value;
            var hireDate = document.getElementById("hireDate").value;

            // Email validation
            var emailPattern = /^[a-zA-Z0-9._%+-]+@emsystem\.com$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address (e.g., user@emsystem.com)");
                return false; // Prevent form submission
            }

            // Phone number validation (must be exactly 10 digits)
            var phonePattern = /^\d{10}$/;
            if (!phonePattern.test(phone)) {
                alert("Please enter a valid 10-digit phone number");
                return false; // Prevent form submission
            }

            // Hire Date validation (must be before today)
            var today = new Date();
            var selectedDate = new Date(hireDate);
            if (selectedDate >= today) {
                alert("Hire date must be before today.");
                return false; // Prevent form submission
            }

            return true; // All validations passed
}

// Function to auto-fill the username field with employee's first name
function autofillUsername() {
    var empName = document.getElementById("empName").value;
    var firstName = empName.split(" ")[0]; // Get the first name
    document.getElementById("username").value = firstName; // Set the username field
}

function confirmUpdate(formId) {
      var confirmation = confirm("Are you sure you want to update this record?");
      if (confirmation) {
          document.getElementById(formId).submit(); // Submit the form if confirmed
      } else {
		window.location.href = 'Read';
        return false; // Do nothing if cancelled
  		}
}

function togglePasswordVisibility(passwordFieldId) {
    var passwordField = document.getElementById(passwordFieldId);
    if (passwordField.type === "password") {
        passwordField.type = "text";  // Show password
    } else {
        passwordField.type = "password";  // Hide password
    }
}

// Function to confirm delete action
function confirmDelete(employeeID) {
    const confirmed = confirm("Are you sure you want to delete this employee?");
    if (confirmed) {
        document.getElementById("deleteForm" + employeeID).submit();
    }
}
document.getElementById('generateBtn').addEventListener('click', function () {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF();

    // Extract table header
    let tableHeaders = [];
    const headers = document.querySelectorAll('#employeeTable thead th');
    headers.forEach(header => {
        tableHeaders.push(header.innerText);
    });

    // Extract table rows
    let tableRows = [];
    const rows = document.querySelectorAll('#employeeTable tbody tr');
    rows.forEach(row => {
        let rowData = [];
        const cells = row.querySelectorAll('td');
        cells.forEach(cell => {
            rowData.push(cell.innerText);
        });
        tableRows.push(rowData);
    });

    // Add table content to the PDF using jsPDF autoTable plugin
    doc.autoTable({
        head: [tableHeaders],
        body: tableRows,
    });

    // Save the PDF
    doc.save('employee-list.pdf');
});





		