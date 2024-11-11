/**
 * 
 */
function validateForm() {
            const employeeId = document.getElementById('employeeId').value;
            const employeeName = document.getElementById('employeeName').value;
            const employeeStatus = document.getElementById('employeeStatus').value;

            // Check if Employee ID is a valid number
            if (!/^\d+$/.test(employeeId)) {
                alert("Please enter a valid Employee ID (numbers only).");
                return false; 
            }

            // Check if Employee Name is filled
            if (employeeName.trim() === "") {
                alert("Please enter the Employee Name.");
                return false; 
            }

            // Check if Employee Status is selected
            if (employeeStatus === "") {
                alert("Please select an Employee Status.");
                return false;
            }

            // Confirmation dialog
            return confirm(`Are you sure you want to submit the following information?\n\nEmployee ID: ${employeeId}\nEmployee Name: ${employeeName}\nEmployee Status: ${employeeStatus}`);
        }