function getItems() {
	//const url = "http://jcdemoopenshift1.conygre.com:8081/items";
	const url = "/items";
	fetch(url)//promise object to return data from Rest API
		.then(response => { return response.json(); }) //resolve , data from resolve is passed to next then
		.then(items => {
			if (items.length > 0) {
				var temp = "";
				items.forEach((itemData) => {
					temp += "<tr>";
					temp += "<td>" + itemData.id + "</td>";
					temp += "<td>" + itemData.name + "</td>";
					temp += "<td>" + itemData.city + "</td>";
					temp += "<td>" + itemData.rating + "</td>";
					temp += "<td> <button class='operations' onclick='populateInputs(" + itemData.id +
						")'>Edit</button>&nbsp;<button class='operations' onClick='deleteItem(" +
						itemData.id + ")'>Delete</button ></td></tr>"
				});
				document.getElementById('tbodyitems').innerHTML = temp;
			}
		});
}

function addItem() {
	const data = {
		id: 0,
		name: document.getElementById('name').value,
		city: document.getElementById('city').value,
		rating: document.getElementById('rating').value
	};
	//const url = "http://jcdemoopenshift1.conygre.com:8081/items";
	const url = "/items";
	fetch(url, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	}).then((response) => {
		document.getElementById('name').value = "";
		document.getElementById('city').value = "";
		document.getElementById('rating').value = "";
		getItems();
	});
}

function populateInputs(id) {
	//const url = `http://jcdemoopenshift1.conygre.com:8081/items/${id}`;
	const url = `/items/${id}`;
	fetch(url)
		.then(response => { return response.json(); })
		.then(item => {
			document.getElementById('id').innerText = item.id;
			document.getElementById('name').value = item.name;
			document.getElementById('city').value = item.city;
			document.getElementById('rating').value = item.rating;
			document.getElementById('save').disabled = false;
			document.getElementById('add').disabled = true;
		});
}

function saveItem() {
	const item = {
		id: document.getElementById('id').innerText,
		name: document.getElementById('name').value,
		city: document.getElementById('city').value,
		rating: document.getElementById('rating').value
	};
	const id = document.getElementById('id').innerText;
	const url = `/items/${id}`;
	//const url = `http://jcdemoopenshift1.conygre.com:8081/items/${id}`;
	fetch(url, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(item)
	}).then((response) => {
		document.getElementById('id').innerText = "";
		document.getElementById('name').value = "";
		document.getElementById('city').value = "";
		document.getElementById('rating').value = "";
		document.getElementById('save').disabled = true;
		document.getElementById('add').disabled = false;
		getItems();
	});
}

function deleteItem(id) {
	const choice = confirm(`Do you want to delete the restaurant with id ${id}?`);
	const url = `/items/${id}`;
    //const url = `http://jcdemoopenshift1.conygre.com:8081/items/${id}`;
	if (choice == true) {
		fetch(url, {
			method: 'DELETE'
		}).then((response) => {
			alert(`The Restaurant with id ${id} has been deleted`);
			getItems();
		});
	}
}
