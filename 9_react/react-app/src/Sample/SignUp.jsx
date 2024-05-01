import React, { useState } from 'react'
//제풀버튼을 클릭시 alert를 이용하여 이름과 성별을 보여주는 팝업을 나타나게해주세요.

//계산값이 바뀌는것은 State로 바꿔주고 고정값은 let로 하면된다.
const SignUp = () => {
    //let name;
    const [name,setName] = useState(""); //State방식
    //let gender;
    const [gender,setGender] = useState("남자"); //State방식

    const handleChangeName = (event) =>{ //바뀐값에 대한 함수
        setName(event.target.value); //한글자 한글자 바뀔때마다 새로그려주는것이다.
    }

    const heandleChangeGender = (event) => {
        setGender(event.target.value);
    }

    const handleSubmit =(event) => {
        alert(`이름 :  ${name}, 성별 : ${gender}`)
        event.preventDefault(); // 이 이벤트를 여기서 끝내라
    }
  return (
    <from onSubmit={handleSubmit}>
        <label>
            이름 : 
            <input type="text" value={name} onChange={handleChangeName} />
        </label>
        <br />
        <label>
            성별 :
            <select value={gender} onChange={heandleChangeGender}>
                <option value="남자">남자</option>
                <option value="여자">여자</option>
            </select>
        </label>
        <button type='submit'>제출</button>
    </from>
  )
}
export default SignUp
