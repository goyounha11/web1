function coffeeRegCheck() {
	var nameInput = document.coffeeRegForm.name;
	var priceInput = document.coffeeRegForm.price;

	if (isEmpty(nameInput)) {
		alert("�޴���!");
		nameInput.value = "";
		nameInput.focus();
		return false;
	}
	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("����!");
		priceInput.value = "";
		priceInput.focus();
		return false;
	}

	return true;
}

function coffeeUpdateCheck() {
	var priceInput = document.coffeeUpdateForm.price;

	if (isEmpty(priceInput) || isNotNumber(priceInput)) {
		alert("����!");
		priceInput.value = "";
		priceInput.focus();
		return false;
	}

	return true;
}