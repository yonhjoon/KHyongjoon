import React, { useState } from 'react'

/*
    Hook이란
    함수형 컴포넌트에서 react state와 생명주기메서드의 기능을 사용할 수 있게 해주는 함수이다.
    hook은 class안에서는 동작하지 않는다. 대신 class없이 React를 사용할 수 있게 해준다.


    const [변수명, set변수명] = useState(초기값);
    변수명 : 원하는 state변수명을 설정하면 된다.
    set변수명 : 해당 state의 값을 변경할 함수

    state : 컴포넌트의 상태값을 말한다.
    useState : 컴포넌트의 상태를 생성하고 관리할 수 있게 해주는 react hook이다.

    컴포넌트는 부모의값이 변경되거나 state값이 변경되면 
    이를 확인하고 요소를 리랜더링 해준다.
*/



const UseStateTest = () => {
    //let num = 0;
    const [num, setNum] = useState(0); //훅은 함수다 즉 얘는 함수다
    //변수명을 다르게해서 따로따로 만들어도된다.

    const onClick1 = () => {
        //num++;
        setNum(num + 1); // 0 => 1 이 되야하는데
        console.log("onClick1 : " + num); // 0찍힘 왜?
        //리랜더링을 하는거라 기본값인 0이 찍히는거다
    }


    const onClick2 = ()=>{
        //num--;
        setNum(num - 1);
        console.log("onClick2 : " + num)
    }
    return (
      <div>
        <span>COUNT : {num}</span>
        <div>
            <button onClick={onClick1}>+</button>
            <button onClick={onClick2}>-</button>
        </div>
      </div>
    )
  }

export default UseStateTest

// const btn = document.createElement('button');
// btn.onclick = this.props.onClick;