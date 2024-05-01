import React from 'react'

const Toolbar = (props) => {
    const {isLoggin, onClickLogin, onClickLogout} = props;

    return (
        <div>
            {isLoggin && <div style={{padding: 24}}>안녕하세요 장용준님</div>} 
            {isLoggin ? // 로그인 상태가 
                <button onClick={onClickLogout}>로그아웃</button> : // 펄스라면 로그아웃
                <button onClick={onClickLogin}>로그인</button>  // 트루 라면 로그인 
            }
        </div>
    )
}
export default Toolbar
