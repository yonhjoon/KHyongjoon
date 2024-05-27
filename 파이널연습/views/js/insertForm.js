document.addEventListener('DOMContentLoaded', function() {
    // 닉네임 중복 체크
    nicknameCheck();
    // 사용자 아이디 중복 체크
    signinIdCheck();
    // 핸드폰 번호 전송 처리
    signinPhoneNumber();
    // 비밀번호 본인확인 버튼
    signinPwdCheck();
    // SubmitButton 제출
    signinSubmitButton();
    // 이메일
    sgininemail();
    // 이메일 아이디적을때 한글안되고 영어만 가능하게
    sgininemailEng();
    // 입력 시 2초 후에 콘솔에 이메일 값을 출력하는 기능입니다.
    emailTimeTwo()
    // 이전페이지로 돌아가는
    backPage();
    // 관심장르 3개이상 못고르게하면서 값 출력되도록
    sginingenreLike();
});

// 닉네임 중복체크
function nicknameCheck() {
    const nicknameInput = document.querySelector("#nickname");
    const nicknameCheckButton = document.getElementById("nickNameCheckButton");
    const nicknameCheckResult = document.getElementById("checkResultNick");
    const nicknameErrorMessage = document.getElementById("nicknameErrorMessage");

    if (nicknameInput && nicknameCheckButton && nicknameCheckResult && nicknameErrorMessage) {
        nicknameCheckButton.addEventListener('click', function() {
            const str = nicknameInput.value;
            if (str.trim().length >= 1) {
                nickCheck({"checkNick" : str}, (result) => callbackNickCheck(result, nicknameCheckResult, nicknameInput))
            } else {
                nicknameCheckResult.style.display = "none";
            }
        });
    } else {
        console.log("닉네임 체크 요소 중 하나가 누락되었습니다.");
    }
}

// 닉네임 중복체크 콜백
function callbackNickCheck(result, nicknameCheckResult, nicknameInput) {
    nicknameCheckResult.style.display = "block";
    if (result === "NNNNN") {
        nicknameCheckResult.style.color = "red";
        nicknameCheckResult.innerText = "이미 사용중인 닉네임입니다.";
        // 닉네임 입력 필드의 값을 없애기
        nicknameInput.value = "";
    } else {
        var regex = /^[a-zA-Z0-9가-힣]{2,16}$/;
        if (!regex.test(nicknameInput.value)) {
            nicknameCheckResult.style.color = "red";
            nicknameCheckResult.innerText = "닉네임은 2 ~ 16글자의 영문, 한글, 숫자로 이루어져야 합니다.";
        } else {
            nicknameCheckResult.style.color = "green";
            nicknameCheckResult.innerText = "사용가능한 닉네임입니다.";
            console.log("닉네임 확인 : " + nicknameInput.value);
        }
    }
}

// 아이디체크
function signinIdCheck() {
    const userIdInput = document.getElementById("user_Id");
    const userIdCheckButton = document.getElementById("idcheckButton");
    const userIdCheckResult = document.getElementById("checkResultId");
    const userIdErrorMessage = document.getElementById("userIdErrorMessage");

    if (userIdInput && userIdCheckButton && userIdCheckResult && userIdErrorMessage) {
        userIdCheckButton.addEventListener('click', function() {
            const str = userIdInput.value.trim(); // 입력된 아이디의 공백을 제거합니다.
            if (str.length >= 1) { // 길이가 1 이상인지 확인합니다.
                console.log("Sending checkId: " + str); // 디버깅을 위한 로그 추가
                idCheck({"checkId" : str}, (result) => callbackIdCheck(result, userIdCheckResult, userIdInput));
            } else {
                userIdCheckResult.style.display = "none";
                userIdErrorMessage.innerText = "아이디는 5글자 이상이어야 합니다.";
            }
        });
    } else {
        console.log("아이디 체크 요소 중 하나가 누락되었습니다.");
    }
}

// 아이디체크 콜백
function callbackIdCheck(result, userIdCheckResult, userIdInput) {
    userIdCheckResult.style.display = "block";
    if (result === "NNNNN") {
        userIdCheckResult.style.color = "red";
        userIdCheckResult.innerText = "이미 사용중인 아이디입니다.";
        // 아이디 입력 필드의 값을 없애기
        userIdInput.value = "";
    } else {
        const idLength = userIdInput.value.length;
        if (idLength < 6 || idLength > 20) {
            userIdCheckResult.style.color = "red";
            userIdCheckResult.innerText = "아이디는 6 ~ 20글자의 영문+숫자로 이루어져야 합니다.";
        } else {
            var regex = /^[a-zA-Z0-9]{6,20}$/;
            if (!regex.test(userIdInput.value)) {
                userIdCheckResult.style.color = "red";
                userIdCheckResult.innerText = "아이디는 6 ~ 20글자의 영문+숫자로 이루어져야 합니다.";
            } else {
                userIdCheckResult.style.color = "green";
                userIdCheckResult.innerText = "사용가능한 아이디입니다.";
                console.log("아이디 확인 : " + userIdInput.value);
            }
        }
    }
}



// 비밀번호 관련 
var timeout; // 전역 범위에 timeout 변수를 선언합니다.

// 비밀번호 / 비밀번호 확인이 서로 틀릴 경우를 처리하는 함수
function validatePassword() {
    clearTimeout(timeout); // 이전에 예약된 작업이 있다면 취소합니다.

    timeout = setTimeout(function() {
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;

        // 입력값이 모두 비어있으면 메시지를 숨깁니다.
        if (password1 === "" && password2 === "") {
            document.getElementById("passwordMessage").innerHTML = "";
            return;
        }

        // 비밀번호가 서로 다른 경우
        if (password1 !== password2) {
            document.getElementById("passwordMessage").innerHTML = "비밀번호가 다릅니다.";
            document.getElementById("passwordMessage").classList.remove("passwordCorrect");
            document.getElementById("passwordMessage").classList.add("passwordIncorrect");
        } else {
            // 비밀번호가 일치하는 경우
            // 비밀번호 유효성 검사: 영문, 숫자, 특수문자 포함, 8글자 이상
            var regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*]).{8,}$/;
            if (!regex.test(password1)) {
                document.getElementById("passwordMessage").innerHTML = "비밀번호는 영문, 숫자, 특수문자를 모두 포함하여 8글자 이상이어야 합니다.";
                document.getElementById("passwordMessage").classList.remove("passwordCorrect");
                document.getElementById("passwordMessage").classList.add("passwordIncorrect");
            } else {
                document.getElementById("passwordMessage").innerHTML = "비밀번호가 일치합니다.";
                document.getElementById("passwordMessage").classList.remove("passwordIncorrect");
                document.getElementById("passwordMessage").classList.add("passwordCorrect");
            }
        }
    });
}
    
// 비밀번호 클릭시 보이도록 (마우스가 눌린 상태에서만)
function togglePasswordVisibility(inputField, isMouseDown) {
    if (isMouseDown && inputField.type === "password") {
        inputField.type = "text";
    } else {
        inputField.type = "password";
    }
}
function signinPwdCheck(){
    let isMouseDown = false;
    const pwdImgElement = document.getElementById("pwdImg");
    const inputField = document.getElementById("password1");

    // 마우스 버튼이 눌린 상태인지 여부를 확인하여 상태 업데이트
    pwdImgElement.addEventListener("mousedown", function() {
        isMouseDown = true;
        togglePasswordVisibility(inputField, isMouseDown);
    });

    // 마우스 버튼이 떼어진 상태인지 여부를 확인하여 상태 업데이트 및 비밀번호 가리기
    pwdImgElement.addEventListener("mouseup", function() {
        isMouseDown = false;
        togglePasswordVisibility(inputField, isMouseDown);
    });
}

// 핸드폰 번호 전송 처리
function signinPhoneNumber (){
    const prefixElement = document.getElementById("phone-prefix");
    const suffix1Element = document.getElementById("phone-suffix1");
    const suffix2Element = document.getElementById("phone-suffix2");
    const inputValueElement = document.getElementById("input-value-phone");

    function updatePhoneNumber() {
        const prefix = prefixElement.innerText;
        const suffix1 = suffix1Element.value;
        const suffix2 = suffix2Element.value;
        const phoneNumber = prefix + suffix1 + suffix2;
        inputValueElement.value = phoneNumber;
    }

    suffix1Element.addEventListener('input', updatePhoneNumber);
    suffix2Element.addEventListener('input', updatePhoneNumber);
}
// 핸드폰 번호 전송 처리
function sendPhoneNumber() {
    // input-value-phone 요소를 가져옵니다.
    var inputValueElement = document.getElementById("input-value-phone");
    if (!inputValueElement) {
        console.error("input-value-phone 요소를 찾을 수 없습니다.");
        return;
    }

    // phone-prefix 요소가 존재하는지 확인
    var prefixElement = document.getElementById("phone-prefix");
    if (!prefixElement) {
        console.error("phone-prefix 요소를 찾을 수 없습니다.");
        return;
    }

    // 010 부분 가져오기
    var prefix = prefixElement.innerText;

    // 각 번호 입력란의 값 가져오기
    var suffix1 = document.getElementById("phone-suffix1").value;
    var suffix2 = document.getElementById("phone-suffix2").value;

    // 전체 번호 조합하여 표시
    var phoneNumber = prefix + suffix1 + suffix2;
    console.log(phoneNumber); // 번호 확인용, 실제 사용시 주석처리해도 됩니다.

    // input-value-phone 필드에 번호 설정
    inputValueElement.value = phoneNumber;
}

// 이메일
function sgininemail(){
    // 필요한 요소들을 가져옵니다.
    const prefixElement = document.getElementById("email-prefix");
    const suffixElement = document.getElementById("email-suffix");
    const domainList = document.getElementById("email-domain-list");
    const inputValueElement = document.getElementById("input-value-email"); // 수정된 부분

    // 이메일 주소를 업데이트하는 함수를 정의합니다.
    function updateEmail() {
        const prefix = prefixElement.value;
        const suffix = suffixElement.value;
        const domain = domainList.value;

        if (domain !== "type") {
            inputValueElement.value = prefix + "@" + domain;
        } else if (prefix && suffix) {
            inputValueElement.value = prefix + "@" + suffix;
        } else {
            inputValueElement.value = "";
        }
        console.log( prefix + "@" + domain)
    }

    // 도메인 리스트 변경 시 처리하는 함수를 정의합니다.
    function handleDomainListChange() {
        const selectedOption = domainList.options[domainList.selectedIndex].value;

        if (selectedOption !== "type") {
            suffixElement.value = selectedOption;
            suffixElement.placeholder = "";
            suffixElement.disabled = true;
        } else {
            suffixElement.value = "";
            suffixElement.placeholder = "직접 입력";
            suffixElement.disabled = false;
        }
        updateEmail(); // 이메일 업데이트 함수를 호출하여 이메일 값을 업데이트합니다.
    }

    // 초기화 함수를 정의합니다.
    function init() {
        handleDomainListChange(); // 도메인 리스트 변경 처리 함수를 호출합니다.
        prefixElement.addEventListener('input', updateEmail); // 프리픽스 입력 시 이메일 업데이트 함수를 호출합니다.
        suffixElement.addEventListener('input', updateEmail); // 서픽스 입력 시 이메일 업데이트 함수를 호출합니다.
        domainList.addEventListener('change', handleDomainListChange); // 도메인 리스트 변경 시 처리하는 함수를 호출합니다.
    }

    init(); // 페이지 로드 시 초기화 함수를 호출합니다.
}

// 입력 시 2초 후에 콘솔에 이메일 값을 출력하는 기능입니다.
let typingTimer;

function emailTimeTwo() {
    const emailInput = document.getElementById("email-prefix");
    const suffixInput = document.getElementById("email-suffix");

    emailInput.addEventListener('input', function() {
        clearTimeout(typingTimer);
        typingTimer = setTimeout(function() {
            const emailPrefix = emailInput.value;
            const emailSuffix = suffixInput.value;
            console.log("입력된 이메일 아이디 값:", emailPrefix + "@");
        }, 2000);
    });

    // 이메일 입력 상자에 대한 이벤트 리스너
    suffixInput.addEventListener('input', function() {
        // 이전에 설정된 타이머를 지웁니다.
        clearTimeout(typingTimer);
        // 500ms 후에 실행되는 타이머 설정
        typingTimer = setTimeout(function() {
            // 이메일 프리픽스와 서픽스 값을 가져와서 이메일 주소로 결합합니다.
            const emailPrefix = emailInput.value;
            const emailSuffix = suffixInput.value;
            console.log("입력된 이메일 주소 값:", emailPrefix + "@" + emailSuffix);
        });
    });
}

// 이메일 아이디적을때 한글안되고 영어만 가능하게
function sgininemailEng(){
    const prefixElement = document.getElementById("email-prefix");
    const userEmailErrorMessage = document.getElementById("userEmailErrorMessage");

    prefixElement.addEventListener('input', function() {
        const value = prefixElement.value;
        const regex = /^[a-zA-Z0-9]*$/; // 영문자와 숫자만 허용하는 정규식

        if (!regex.test(value)) {
            // 입력된 값이 한글인 경우 빈 문자열로 대체하여 입력값을 영문만 포함하도록 합니다.
            prefixElement.value = value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '');

            // userEmailErrorMessage에 영어 입력만 가능합니다 메시지 추가
            if (userEmailErrorMessage) {
                userEmailErrorMessage.innerText = "영어 입력만 가능합니다.";
                userEmailErrorMessage.style.color = "red";
            }
        } else {
            // 한글 입력이 아닐 때 에러 메시지를 초기화합니다.
            if (userEmailErrorMessage) {
                userEmailErrorMessage.innerText = "";
            }
        }
    });
}

//주소 불러오기 - kakao 우편번호 서비스 api (https://postcode.map.daum.net/guide)
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // (건물이름 건물 동) 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // sample6_postcode = 우편번호 > 04766
            // sample6_execDaumPostcode = 우편번호 찾기 > (버튼)
            // sample6_address = 주소 > 서울숲길 17
            // sample6_detailAddress = 상세주소 > 동/호수
            // sample6_extraAddress =  참고사항 > 성수동1가(지번), 성수파크빌(건물이름)

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }

                // // 조합된 참고항목을 해당 필드에 넣는다.
                // document.getElementById("sample6_extraAddress").value = extraAddr;
                document.getElementById("sample6_address").value = addr + extraAddr;
            } else {
                // document.getElementById("sample6_extraAddress").value = '';
                document.getElementById("sample6_address").value = addr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            // document.getElementById("sample6_address").value = addr + extraAddr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

// 주소 확인
function updateAddressDisplay() {
    const addressInput = document.getElementsByClassName("addressInput")[0];
    const detailAddressInput = document.getElementsByClassName("detailAddressInput")[0];
    const sample6_postcode = document.getElementById("sample6_postcode");
    const addressDisplay = document.getElementById("input-value-address");

    if (addressInput && detailAddressInput && addressDisplay) {
        const addressValue = addressInput.value;
        const detailAddressValue = detailAddressInput.value;
        const sample6Value = sample6_postcode.value;

        // 주소와 자세한 주소를 결합하여 주소 표시 요소에 설정
        const fullAddress = "[" + sample6Value + "] " + addressValue + " " + detailAddressValue;
        addressDisplay.value = fullAddress;

        // 콘솔에 출력
        console.log("주소 값:", fullAddress);
    }
}

function checkAddress() {
    updateAddressDisplay();
}

// 이전페이지로 돌아가는
function backPage(){
    var backButton = document.getElementById('backButton');
    backButton.addEventListener('click', function() {
        //console.log("작동됨"); // 이 부분이 정상적으로 실행되지 않는다면 문제가 있을 수 있습니다.
        window.history.back();
    });
}

// 3개이상 못고르게하면서 값 출력되도록
function sginingenreLike(){
    const genreLikeInput = document.querySelector("input[name='genreLike']");
    const buttons = document.querySelectorAll('.btn-staez3');

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            if (button.classList.contains('selected')) {
                button.classList.remove('selected');
            } else {
                const selectedButtons = document.querySelectorAll('.btn-staez3.selected');
                if (selectedButtons.length < 3) {
                    button.classList.add('selected');
                } else {
                    // 선택 가능한 최대 개수를 초과한 경우 경고 메시지를 표시
                    alert("최대 갯수입니다.");
                }
            }
            updateInput();
        });
    });
    
    function updateInput() {
        const selectedButtons = document.querySelectorAll('.btn-staez3.selected');
        const selectedGenres = Array.from(selectedButtons).map(button => button.getAttribute('data-genre'));
        genreLikeInput.value = selectedGenres.join(' ');
    }
}



// 모든정보가 저장되야 다음버튼 활성화
function signinSubmitButton(){
    // 다음 버튼 클릭 이벤트
    const submitButton = document.getElementById('submitButton'); // 버튼 요소 가져오기
    const form = document.getElementById('enrollForm'); // 폼 요소 가져오기

    submitButton.addEventListener('click', function(event) {
        event.preventDefault(); // 폼 제출을 막음
        const isValid = validateForm();
        if (isValid) {
            form.submit(); // 폼을 수동으로 제출
        } else {
            console.log("입력값이 올바르지 않습니다. 모든 필수 입력란을 작성해주세요.");
        }
    });

        
    function validateForm() {
        var nickname = document.getElementById("nickname").value; //닉네임
        var userId = document.getElementById("user_Id").value; // 아이디
        var password1 = document.getElementById("password1").value; // 비밀번호
        var password2 = document.getElementById("password2").value; // 비밀번호 확인
        var phone = document.getElementById("input-value-phone").value; // 핸드폰
        var email = document.getElementById("input-value-email").value; // 이멜
        var birth = document.getElementsByName("birth")[0].value; // 생일
        var address = document.getElementById("input-value-address").value; // 주소
    
        if (nickname === "" || userId === "" || password1 === "" || password2 === "" || 
            phone === "" || email === "" || birth === "" || address === "") {
            alert("입력값이 올바르지 않습니다. 모든 필수 입력란을 작성해주세요.");
            return false; // 폼 제출을 막음
        }
        return true; // 폼 제출을 허용
    }

}