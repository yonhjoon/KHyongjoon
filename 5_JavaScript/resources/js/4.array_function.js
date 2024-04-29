let members = [
    '장용준',
    '윤세련',
    '최지원',
    '김지원',
    '박지원'
]

// push - 리스트에 넣음
console.log(members.push('신지원'));
console.log(members)

//splice() 0번째부터 3번째까지 뺴고 지워
console.log(members.splice(0,3));

//concat - 찾아서 잘라주는거 즉 제거해주는거
console.log(members.concat("지지원"));
console.log(members);

members = [
    '장용준',
    '윤세련',
    '최지원',
    '김지원',
    '박지원'
]

let members2 = [
    // '...' 은 내부적인 요소를 전부 복사해오는거
    ...members
]
console.log(members2);

console.log("----------------------------------------------------------------------");

let memberInfo = {
    name: "용준",
    age: 47,
    gender: 'M'
}

let memberInfo2 ={
    ...memberInfo,
    age: 12 // 마지막으로 넣은 컬럼이 원래 컬럼을 덮어쓴다
    // 수정할때 많이 사용한다
}

console.log(memberInfo2)

console.log("----------------------------------------------------------------------");

//join()
console.log(members2.join());
console.log(members2.join('/')); //구분자 /
console.log(members2.join(' ')); //구분자 (공백)

//sort()
members2.sort();
console.log(members2); // ㄱㄴㄷ 순으로 정렬
console.log(members2.reverse()); // 반대로 정렬

let numbers = [1,9,7,5,3]
console.log(numbers);

// a,b를 비교한다.
// 1) a를 b보다 나중에 정렬하고 싶다면 (뒤에두려면) 0보다 큰수를 반환
// 2) a를 b보다 먼저 정렬하려한다면 (앞에두려면) 0보다 작은 숫자를 반환한다.
// 3) 원래순서를 유지하고 싶다면 0을 반환한다. 
numbers.sort((a,b) => {
    // => : function 이랑 같다
    // return a > b ? 1 : -1; // 기본값 -> 오름차순 정렬
    // return a < b ? 1 : -1; // 내림차순 정렬
});
//console.log(numbers); // 오름차순 정렬

numbers.sort((a,b) => a < b ? 1 : -1); //이런식으로 생략 가능
console.log(numbers);

console.log("----------------------------------------------------------------------");

//map
// 기존배열의 요소를 전부 반복하면서
// return된 값으로 새로운 배열을 만들어주는 함수
// 모든값을 바꿀때도 쓰지만 모든맴버에'등급'을 넣을때 많이 사용한다.
// 2개의 배열을 합칠때도 많이 쓰인다.
// console.log(members2.map((m) => {
//     if(m.length > 3){
//         return m + "[vip]";
//     } else{
//         return m + "[gold]";
//     }
// })); // m이라는 파라미터를 전달받아서 m을 리턴한다.
// =>
// let tmpMembers = [];
// for(let m of members2){
//     tmpMembers.push(m + 1);
// }

let classList = [{
    className : "자바 1장",
    time : "12 : 00",
    classNo : 1
},{
    className : "자바 2장",
    time : "13 : 00",
    classNo : 2
},{
    className : "자바 3장",
    time : "14 : 00",
    classNo : 3
}]

let studentList = [{
    name : "최지원",
    classNo : 1
},{
    name : "최지원2",
    classNo : 3
},{
    name : "최지원3",
    classNo : 2
},{
    name : "최지원4",
    classNo : 2
},{
    name : "최지원5",
    classNo : 1
}]

console.log(studentList.map( s => {
    for(let c of classList) { // classList안에서 조건을 찾는것
        if(s.classNo === c.classNo) {
            return {
                ...c,
                ...s
            }
        }
    }
    // for 문을 filter로 변경해보기 (숙제)

    return s;
}))

//filter()
// // 원래 짝수만 출력할때
// let tmp2 = [];
// for(let n of numbers2){
//     if(n%2 === 0){
//         tmp2.push(n);
//     }
// }

let numbers2 = [1,8,7,6,3]; //짝수 구하기
tmp2 = numbers2.filter(n => n % 2 === 0);//이런식으로 간단하게 가능하다
console.log(numbers2.filter(n => n % 2 === 0)) // 트루인값만 생성 펄스인값을 버리고 n에 남겨준다

// find() 이 값이 있냐없냐할때 주로 사용한다.
console.log(tmp2.find(n => n % 2 === 0)); // 내가 원하는 요소만 나오게 한다
// console.log(tmp2.find(n => n % 2 === 1)); 안에는 1이 없으므로 undefined가 나온다 즉 너가 원하는 값이 없다

//findIndex() // 어떠한 list안에서 값을 찾을떄
console.log(numbers2);
console.log(numbers2.findIndex(n => n % 2 === 0));

// reduce
//(p,n) => p + n 이거는 함수 1번째 파라미터, 0 은 2번째 파라미터
// reduce ((, 배열의 요소) => {}, 초기값)
// 배열을 통해서 특정 변수 하나를 만들 때 사용한다.
console.log(numbers2.reduce((p,n) => p + n,0));
console.log(numbers2.reduce((sum,n) => {
    if(n % 2 === 1){
        sum.push(n);
    }
    return sum;
}, []))




