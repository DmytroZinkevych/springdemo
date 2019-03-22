function toArgs(arr) {
	let argStr = "";
	for(let i = 0; i < arr.length; i++) {
		if (argStr.length > 0) {
			argStr += ",";
		}
		argStr += arr[i];
	}
	return argStr;
}

$(document).ready( () => {
	$("#dep-table").DataTable({
		paging: false,
		info: false
	});

	let empTable = $("#emp-table").DataTable({
		paging: false,
		info: false,
		columnDefs: [
            {
                targets: [5],
                visible: false,
                // searchable: false
            },
        ]
	});

	let depCheckboxes = document.getElementsByClassName("department-checkbox");
	let ids = [];
	let searchFunction = (settings, data, dataIndex) => {
		if (ids.length == 0) {
			return true;
		}
		return ids.includes(data[5]);
	}

	$.fn.dataTable.ext.search.push(searchFunction);

    for(let i = 0; i < depCheckboxes.length; i++) {
    	if (depCheckboxes[i].closest("tr").classList.contains("selected")) {
    		ids.push(depCheckboxes[i].value);
    		depCheckboxes[i].checked = true;
		}
    	depCheckboxes[i].addEventListener("change", () => {
    		if(depCheckboxes[i].checked) {
    			depCheckboxes[i].closest("tr").classList.add("selected");
    			if (ids.indexOf(depCheckboxes[i].value) == -1) {
    				ids.push(depCheckboxes[i].value);
    			}
				// window.location.replace("/getEmployees?dep_id=" + toArgs(ids));
				empTable.draw();
    		} else {
    			ids.splice(ids.indexOf(depCheckboxes[i].value), 1);
				depCheckboxes[i].closest("tr").classList.remove("selected");
				empTable.draw();
				/*
    			if (ids.length > 0) {
    				window.location.replace("/getEmployees?dep_id=" + toArgs(ids));
    			} else {
    				window.location.replace("/getEmployees");
				}
				*/
    		}
    	});
    };
});
