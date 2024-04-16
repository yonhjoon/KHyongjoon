/**
 * Hoisting
 */

console.log(name); // undefined : 변수를 만들고 사용하지않을때 (개발자가 의도해서 값을 안넣은건 null 아닌건 undefined)
var name1 = "yongjoon";
console.log(name);

/**
 * 
 * Hoisting은 뭘까?
 * 
 * 모든 변수 선언문이 코드의 최상단으로 이동되는 것처럼 느껴지는 현상
 * let, const
 * 
 * TDZ : 일시적 사각지대
 */

console.log(name);
let name2 = "yongjoon";
