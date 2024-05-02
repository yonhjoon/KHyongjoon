import React, {useMemo} from 'react'

const getNumber = (num) => {
    console.log("숫자가 변경되었다. + 1해서 보여주기")
    return num + 1;
}

const getText = (text) => {
    console.log("글자가 변경되었다.")
    return text;
}

const ViewState = ({num, text}) => {
    //const {num, text} = props; 로 할 수 도 있다.
    // const viewNum = getNumber(num);
    // const viewText = getText(text);

    const viewNum = useMemo(() => getNumber(num),[num])
    const viewText = useMemo(() => getNumber(text),[text])

    return (
        <div>
            {viewText} <br />
            {viewNum}
        </div>
    )
}

export default ViewState