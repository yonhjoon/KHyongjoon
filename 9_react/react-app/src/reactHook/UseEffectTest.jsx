// rafce

import React, { useEffect, useState }from 'react'

/**
 * useEffect
 * 컴포넌트가 랜더링 될때 특정 작업을 실행할 수 있도록 하는 react hook
 * 클래스형 컴포넌트의 생명주기메소드의 역할을 할 수 있다.
 * 
 * 컴포넌트가 마운트됐을 때(처음 나타났을 때(생성됬을 때), 언마운트됐을 때(사라질 때))
 * 업데이트됐을 때(특정 state, props가 바뀌었을 때)
 * 
 * 사용법
 * useEffect(effect(함수), [](의존성));
 * 첫번째 인자(effect) : 함수 -> 특정상황에서 실행시켜줄 기능
 * 두번째 인자 : 배열 -> 의존성배열
 */

const UseEffectTest = () => {
    //네임을 변경하기위해
    const [name, setName] = useState("장용준");
    const [num, setNum] = useState(0);

    const handleKeyUpName = (ev) => {
      setName(ev.target.value);
    }

    const handleClickNum = (ev) => {
      setNum(num + 1);
    }

    const handleClickNumM = (ev) => {
      setNum(num - 1);
    }

    //렌더링이 되었을 때, 그리고 state가 변경될 때 마다 console.log가 찍혔다.
    // componentDidMount & componentDidUpdate의 역할을 대체할 수 있다.
    useEffect(() => {
      console.log("의존성 배열이 없는 useEffect호출1");
    })

    // 랜더링이되었을 때 한번만 실행이된다.
    // componentDidMount의 역할을 대체하고 있다.
    useEffect(() => {
      console.log("빈배열을 의존성배열로 가진 useEffect호출2");
    },[])

    // 특정값이 변할때 다른 코드의 영향이 있는 코드에 넣어준다.
    // 랜더링이 되있을 때, 그리고 name state가 변경되었을 때 호출된다.
    // 의존성배열안에있는 state가 변하면 해당 effect함수를 호출해준다. 
    // componentDidMount & componentDidUpdate
    useEffect(() => {
      console.log("[name]의존성배열로 가진 useEffect호출3");
    },[name])

    // return함수를 추가하여 componentWillUnmount 역할을 할 수 있다.
    useEffect(() => {
      return () => {
        console.log("함수를 리턴하는 useEffect호출4");
      }
    },[name])

  return (
    <div>
        <p>안녕하세요. {name} 입니다.</p>
        <input type="text" onKeyUp={handleKeyUpName}/>
        <p>{num}번 클릭</p>
        <button onClick={handleClickNum}>+</button>
        <button onClick={handleClickNumM}>-</button>
    </div>
  )
}
export default UseEffectTest