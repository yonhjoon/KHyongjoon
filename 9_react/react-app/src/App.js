import logo from './logo.svg';
import './App.css';
import Menu from './components/Menu';
import Comment from './components/Comment';
import CommentList from './classComponent/CommentList';
import UseStateTest from './reactHook/UseStateTest'; // 훅 카운터 올리기
import SignUp from './Sample/SignUp'; //이름 성별 입력해서 제출
import  LandingPage  from './Sample/LandingPage'; // 로그인 로그아웃
import  UseEffectTest  from './reactHook/UseEffectTest'; //Effect의 대해
import UseCallbackTest from './reactHook/useCallback/UseCallbackTest';
import UseRefTest from './reactHook/UseRefTest';
// import 파일이름 from './폴더이름/파일이름';

// 임폴트가 되면 그 파일을 불러온다
function App() {
  return (
    <div className="App">
      {/* <Menu /> */} 
      {/* <Comment /> */}
      {/* <CommentList /> */}
      {/* <UseStateTest/> */}
      {/* <SignUp/> */}
      {/* <LandingPage /> */}
      {/* <UseEffectTest /> */}
      {/* <UseCallbackTest/> */}
      <UseRefTest/>
    </div>
  );
}

export default App;
