import React, { useState } from 'react'
import ViewItems from './ViewItems';

const UseCallbackTest = () => {
    const [num, setNum] = useState(1)
    const [dark, setDark] = useState(false);

    const getItems = () => {
        return [num, num+1, num+2]
    }

    const theme = {
        backgroundColor: dark ? "#333" : "#fff",
        color: dark ? "#fff" : "#333"
    }

    const onChangeNum = (ev) => {
        setNum(parseInt(ev.target.value));
    }

    return (
        <div style={theme}>
            <input 
                type="number"
                value={num}
                onChange={onChangeNum}
            />
            <button onClick={() => {setDark(!dark)}}>테마 변경</button>
            <ViewItems getItems={getItems} />
        </div>
    )
}

export default UseCallbackTest