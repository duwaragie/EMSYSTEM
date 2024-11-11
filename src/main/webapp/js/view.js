/**
 * 
 */
 
    function filterEmployees() {
        const input = document.getElementById('searchField').value.toLowerCase();
        const table = document.getElementById('employeeTable');
        const rows = table.getElementsByTagName('tr');

        for (let i = 1; i < rows.length; i++) {
            const cells = rows[i].getElementsByTagName('td');
            const employeeId = cells[0].textContent || cells[0].innerText;
            const employeeStatusSelect = cells[2].getElementsByTagName('select')[0];
            const employeeStatus = employeeStatusSelect.options[employeeStatusSelect.selectedIndex].text.toLowerCase(); // Get the text of the selected option

       
            const idMatch = employeeId.toLowerCase() === input;
            const statusMatch = employeeStatus === input;

            rows[i].style.display = (idMatch || statusMatch) ? '' : 'none';
        }
    }

		function confirmUpdate(formId) {
		      var confirmation = confirm("Are you sure you want to update this record?");
		      if (confirmation) {
		          document.getElementById(formId).submit(); 
		      } else {
				window.location.href = 'ReadStat';
		        return false; // Dont do anything if cancelled
		  		}
		}
		

		function confirmDelete(formId) {
				    var confirmation = confirm("Are you sure you want to delete this record?");
				      if (confirmation) {
				          document.getElementById(formId).submit(); 
				      } else {
						window.location.href = 'ReadStat';
				        return false; // Dont do anything if cancelled
				  		}
				}
				
