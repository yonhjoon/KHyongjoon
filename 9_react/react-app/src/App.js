import logo from './logo.svg';
import './App.css';
import Menu from './components/Menu';
import Comment from './components/Comment';
import CommentList from './classComponent/CommentList';
import UseStateTest from './reactHook/UseStateTest';
import SignUp from './Sample/SignUp';
import  LandingPage  from './Sample/LandingPage';
// import 파일이름 from './폴더이름/파일이름';

// 임폴트가 되면 그 파일을 불러온다
function App() {
  return (
    <div className="App">
      <LandingPage />
    </div>
  );
}

export default App;
