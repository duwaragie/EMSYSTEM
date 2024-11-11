function calculateNetSalary() {
    // Get values from input fields
    let basicSalary = parseFloat(document.getElementById('basicSalary').value) || 0;
    let allowance = parseFloat(document.getElementById('allowance').value) || 0;
    let deductions = parseFloat(document.getElementById('deductions').value) || 0;

    // Validation: Ensure values are not negative
    if (basicSalary < 0) {
        alert("Basic salary cannot be a negative value.");
        document.getElementById('basicSalary').value = '';
        return;
    }

    if (allowance < 0) {
        alert("Allowance cannot be a negative value.");
        document.getElementById('allowance').value = '';
        return;
    }

    if (deductions < 0) {
        alert("Deductions cannot be a negative value.");
        document.getElementById('deductions').value = '';
        return;
    }

    // Validation: Allowances and deductions cannot be greater than basic salary
    if (allowance > basicSalary) {
        alert("Allowance cannot be greater than the basic salary.");
        document.getElementById('allowance').value = '';
        return;
    }

    if (deductions > basicSalary) {
        alert("Deductions cannot be greater than the basic salary.");
        document.getElementById('deductions').value = '';
        return;
    }

    // Calculate Net Salary
    let netSalary = basicSalary + allowance - deductions;

    // Display Net Salary in the input field
    document.getElementById('netSalary').value = netSalary.toFixed(2);
}

function validateForm() {
    // Call the salary calculation and validation logic
    calculateNetSalary();

    // Get the final net salary for submission check
    let netSalary = document.getElementById('netSalary').value;

    // Ensure net salary is a valid number before submitting
    if (isNaN(netSalary) || netSalary <= 0) {
        alert("Please ensure the form is correctly filled and Net Salary is valid.");
        return false; // Prevent form submission
    }

    // If everything is valid, allow form submission
    return true;
}

function confirmUpdate(payrollID) {
    var confirmation = confirm("Are you sure you want to update this record?");
    if (confirmation) {
        document.getElementById(payrollID).submit(); // Submit the form if confirmed
    } else {
        return false; // Do nothing if cancelled
    }
}

function confirmDelete(payrollID) {
    // Display a confirmation dialog box
    if (confirm("Are you sure you want to delete this payroll record?")) {
        // If the user clicks "OK", submit the form to delete the record
        document.getElementById('deleteForm' + payrollID).submit();
    } else {
        // If the user clicks "Cancel", do nothing
        return false;
    }
}