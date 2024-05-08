// import logo from './logo.svg';
// import './App.css';
// import Menu from './components/Menu';
// import Comment from './components/Comment';
// import CommentList from './classComponent/CommentList';
// import UseStateTest from './reactHook/UseStateTest'; // 훅 카운터 올리기
// import SignUp from './Sample/SignUp'; //이름 성별 입력해서 제출
// import  LandingPage  from './Sample/LandingPage'; // 로그인 로그아웃
// import  UseEffectTest  from './reactHook/UseEffectTest'; //Effect의 대해
// import UseCallbackTest from './reactHook/useCallback/UseCallbackTest'; // 테마변경
// import UseRefTest from './reactHook/UseRefTest'; // 제출 및 초기화
// import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom';
// import Home from './pages/Home';
// import FoodMenu from './pages/FoodMenu';
// // import 파일이름 from './폴더이름/파일이름';

// /*
//   react-router-dom
//   react로 생성된 SPA 내부에서 페이지 이동이 가능하도록 만들어주는 라이브러리

//   BrowserRouter(Router)
//   history API를 이용해서 history객체를 생성한다. history : 
//   라우팅을 진행할 컴포넌트 상위에 Router컴포넌트를 생성하고 감싸주어야한다.

//   Routes
//   모든 Route의 상위경로에 존재해야하며, location 변경시 하위에 있는 모든 Route중에서
//   현재 location과 맞는 Route를 찾아준다.

//   Route
//   현재 브라우저의 location(window.href.location 정보를 가져온다.) => 상태에 따라서 다른 element를 랜더링한다.

// */

// // 임폴트가 되면 그 파일을 불러온다
// function App() {
//   return (
//     <Router>
//       <div className="App">
//         {/* <Menu /> */} 
//         {/* <Comment /> */}
//         {/* <CommentList /> */}
//         {/* <UseStateTest/> */}
//         {/* <SignUp/> */}
//         {/* <LandingPage /> */}
//         {/* <UseEffectTest /> */}
//         {/* <UseCallbackTest/> */}
//         {/* <UseRefTest/> */}
//         {/* ------------------------- */}
//             <nav>
//               <ul>
//                 <li>
//                   <Link to="/">Home</Link>
//                 </li>
//                 <li>
//                   <Link to="/food">Food List</Link>
//                 </li>
//               </ul>
//             </nav>
//           <Routes>
//               <Route path='/' element={<Home/>}/>
//               <Route path='/food' element={<FoodMenu />}/>
//           </Routes>
//       </div>
//     </Router>
//   );
// }

// export default App;


//24 05 07 화면구현 시험
import './default.css'; // default.css 파일을 import합니다.

import { useState } from "react"; // React 라이브러리에서 useState 훅을 import합니다.

function App() {
    // useState 훅을 사용하여 userList 상태와 초기값을 설정합니다.
    const [userList, setUserList] = useState([
        { name: "유저1", age: 24, gender: "남자", phone: "010-2732-2241" },
        { name: "유저2", age: 27, gender: "여자", phone: "010-2674-0093" },
        { name: "유저3", age: 30, gender: "남자", phone: "010-3784-2834" },
    ]);

    // useState 훅을 사용하여 name, age, gender, phone 상태 및 초기값을 설정합니다.
    const [name, setName] = useState(""); 
    const [age, setAge] = useState(""); 
    const [gender, setGender] = useState("");
    const [phone, setPhone] = useState(""); 

    // 회원 등록 함수를 정의합니다.
    const registUser = () => { 
        // 입력된 정보로 새로운 user 객체를 생성합니다.
        const user = { name, age, gender, phone }; 
        // userList 배열에 새로운 user 객체를 추가합니다.
        userList.push(user); 
        // setUserList를 통해 userList 상태를 갱신합니다.
        setUserList([...userList]); 
        // 입력 필드 값을 초기화합니다.
        setName(""); 
        setAge(""); 
        setGender(""); 
        setPhone(""); 
    };

    return ( 
        <div className="App"> 
            <h1>회원 정보 출력</h1>
            <hr></hr>
            <table className="member_tbl"> 
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>나이</th>
                        <th>성별</th>
                        <th>전화번호</th>
                    </tr>
                </thead>
                <tbody>
                    {userList.map((item, index) => { // map똑같은 요소를 복사하는
                        // User 컴포넌트를 userList 배열의 각 요소에 대해 렌더링합니다.
                        return <User key={"user" + index} user={item} />;
                        //밑 const user = props.user; 에 user을 가져오는거니  user={item} 가 맞다
                    })}
                </tbody>
            </table>
            <div className="regist-wrap">
                <h3>회원 정보 등록</h3>
                <hr></hr>
                {/* InputWrap 컴포넌트를 사용하여 입력 필드를 렌더링합니다. */}
                <InputWrap text="이름" data={name} setData={setName} />
                <InputWrap text="나이" data={age} setData={setAge} />
                <InputWrap text="성별" data={gender} setData={setGender} />
                <InputWrap text="전화번호" data={phone} setData={setPhone} />
                <button onClick={registUser}>회원등록</button>
            </div>
        </div>
    );
}

// User 컴포넌트 정의
const User = (props) => {
    // props로 전달된 user 객체를 받아와서 사용합니다.
    const user = props.user;
    return (
        <tr>
            {/* 사용자 정보를 테이블에 출력합니다. */}
            <td>{user.name}</td>
            <td>{user.age}</td>
            <td>{user.gender}</td>
            <td>{user.phone}</td>
        </tr>
    );
};

// 입력 필드를 렌더링하는 InputWrap 컴포넌트 정의
const InputWrap = (props) => {
    const text = props.text; // 레이블 텍스트를 props로부터 받아옵니다.
    const data = props.data; // 입력된 데이터를 props로부터 받아옵니다.
    const setData = props.setData; // 데이터 변경 함수를 props로부터 받아옵니다.
    
    // 입력 값이 변경될 때 호출되는 함수
    const changeInputValue = (e) => {
        setData(e.target.value); // 입력된 값을 상태에 반영합니다.
    };

    return (
        <div className="input_wrap">
            <label>{text}</label>
            {/* 입력 필드를 렌더링하고 입력값이 변경될 때 changeInputValue 함수가 호출됩니다. */}
            <input type="text" value={data} onChange={changeInputValue} />
        </div>
    );
};

export default App;




          // 1. CSS 파일을 import합니다.
//          import './default.css';

          // 2. React 라이브러리에서 useState 훅을 import합니다.
//          import { useState } from "react";

          // 3. App 컴포넌트를 정의합니다.
//         function App() {
              // 4. userList 상태와 초기값을 설정합니다.
//              const [userList, setUserList] = useState([
//                  { name: "유저1", age: 24, gender: "남자", phone: "010-2732-2241" },
//                  { name: "유저2", age: 27, gender: "여자", phone: "010-2674-0093" },
//                  { name: "유저3", age: 30, gender: "남자", phone: "010-3784-2834" },
//              ]);

              // 5. name, age, gender, phone 상태와 초기값을 설정합니다.
//              const [name, setName] = useState(""); 
//              const [age, setAge] = useState(""); 
//              const [gender, setGender] = useState("");
//              const [phone, setPhone] = useState(""); 

              // 6. 회원 등록 함수를 정의합니다.
//              const registUser = () => {
                  // 새로운 user 객체를 생성하고 userList에 추가합니다.
//                  const user = { name, age, gender, phone }; 
//                  userList.push(user); 
//                  setUserList([...userList]); 
//                  setName(""); 
//                  setAge(""); 
//                  setGender(""); 
//                  setPhone(""); 
//              };

              // 7. App 컴포넌트의 렌더링을 설정합니다.
//              return (
                  // JSX로 화면을 구성합니다.
//              );
//          }

          // 8. User 컴포넌트를 정의합니다.
//          const User = (props) => {
              // 사용자 정보를 테이블에 출력합니다.
//          };

          // 9. InputWrap 컴포넌트를 정의합니다.
//          const InputWrap = (props) => {
              // 입력 필드를 렌더링합니다.
//          };

          // 10. App 컴포넌트를 export합니다.
//          export default App;