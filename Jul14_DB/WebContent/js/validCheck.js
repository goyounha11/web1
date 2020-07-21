// 자바스크립트 유효성 검사 라이브러리 제작

// 일반적으로 유효성검사 하는 것들 함수형태로 정리해서 나중에 쓰기 편하게
// 문제가 있으면 true, 괜찮으면 false

// <input>을 넣으면
// 거기 글자가 없으면 true, 있으면 false
function isEmpty(input) {
	return !input.value;
}

// <input>, 글자수를 넣으면
// 그 글자수보다 적게 썼으면 true, 아니면 false
function lessThan(input, l) {
	return input.value.length < l;
}

// <input>을 넣으면 : a12ㅋb23
// 한글/특수문자 들어있으면 true, 아니면 false
function containsHS(input) {
	var ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@._";
	for (var i = 0; i < input.value.length; i++) {
		if (ok.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

// <input> x 2 넣으면
// 내용이 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return input1.value != input2.value;
}

// <input>, 문자열셋트 넣으면
// 그 문자열셋트의 글자가 포함 안되어있으면 true
// 들어있으면 false
function notContains(input, set) {
	// input.value : qwerASDㅋㅋㄹ
	// set : 1234657890
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input>을 넣
// 숫자가 아니면 true, 숫자면 false
function isNotNumber(input) {
	return isNaN(input.value);
}

// <input>, 확장자를 넣
// 그게 아니면 true, 그거면 false
function isNotType(input, type) {
	type = "." + type; // .png
	return input.value.indexOf(type) == -1;
}