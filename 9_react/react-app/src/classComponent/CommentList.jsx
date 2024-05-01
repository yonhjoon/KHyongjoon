import React, { Component } from 'react'
import Comment from './Comment'

//데이터 더미 만들기
const serverComments = [
    {
        id : 1,
        message : "안녕하세요. 오늘 쉬나요?"
    },
    {
        id : 2,
        message : "안녕하세요. 저는 안쉽니다"
    },
    {
        id : 3,
        message : "아하~ 저는 쉬어요"
    }
]

let timer;

/**
 *  class Component
 *  state(필드대체)를 가지고있고 이를 수정할 수 있다.
 *  라이프사이클에 따른 생명주기메서드를 사용할 수 있다.
 *  
 */

export default class CommentList extends Component {
    constructor(porps){
        super(porps)
        // props => 

        this.state = {
            commentList: []
        }
    }

    componentDidMount(){
        console.log("componentDidMount")
        const {commentList} = this.state; // 비구조할당
        // const commentList} = this.state.commentList; 랑 같은것

        // setInterval : 일정 시간마다 특정 함수를 반복해서 반복
        timer = setInterval(() => {
            //2초마다 실행되는 부분
            if(commentList.length < serverComments.length){
                const index = commentList.length; // 0
                commentList.push(serverComments[index]);
                this.setState({
                    //commentList: commentList
                    ...commentList // 신문법 새롭게 많이 쓰인다
                })
            } else{

                this.setState({
                    commentList : []
                }); //비워준다

                clearInterval(timer) // 종료
            }
        }, 1000) //밀리터 기준으로 2000은 2초다
    }



  render() {
    return (
      <div>
        {
            this.state.commentList.map(c => {
                return(
                    <Comment
                        key={c.id}
                        id={c.id}
                        message={c.message}
                    />
                )
            })
        }
      </div>
    )
  }
}


// 클린함수의 안좋은 예
// const.add(data){
//     const.sum = data.a + data.b
//     data.a = 7
//     return.sum;
// }

// let t = {
//     a:5,
//     b:3
// }

// result = add(t)

// t