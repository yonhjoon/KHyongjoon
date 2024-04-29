
//let todoList = []; // todoList라는 배열을 만들어준다.
let todoList = localStorage.getItem("todoList") ? 
                JSON.parse(localStorage.getItem("todoList")) : []; // 있으면 넣어주고 ? 없으면 : []

// JSON.stringify(todoList) => todoList변수에 담긴 배열요소를 String(문자열)로 변환
//JSON.parse(localStorage.getItem("todoList")) => localStorage.getItem("todoList")에 저장된 String데이터를 다시 배열요소로 변환

//localStorage.setItem("todoList",JSON.stringify(todoList)); => localStorage영역에 key, value형태로 데이터 저장
//localStorage.getItem("todoList") => localStoryge영역에 데이터를 key로 불러오는 것

window.onload = function(){
    drawTodoList();
}

// 해야할 일을 todoList태크에 넣어주기
function addTodo(){
    //input요소 가져오기
    const searchInput = document.querySelector("#search-bar input");
    todoList.push({
        title: searchInput.value, //input벨류값
        date : new Date().getTime(), // 값이 들어간 시간
        isDone: false
    });

    searchInput.value = "";
    localStorage.setItem("todoList",JSON.stringify(todoList)); //추가할때 키값형태로 넣는다 둘다 문자열로 넣어야한다.
    drawTodoList(); // drawTodoList 이벤트 발생시킴
}

//해야할 일 목록을 ui에 그려주기
function drawTodoList(){
    // X를 누르면 input의 value값 지우기
    const removeTodo = function(removeTodo){
        //todoList에서 removeTodo와 같은 데이터를 삭제
        todoList = todoList.filter(t => (removeTodo.date !== t.date && removeTodo.title !== t.title)) // 반환값이 true인 데이터만 남기고 전부 삭제된 배열을 반환
        //todoList에서 todo와 같은 데이터를 삭제
        localStorage.setItem("todoList",JSON.stringify(todoList));
        drawTodoList();
    }

    const toggleStatus = function(targetTodo){
        todoList = todoList.map(t => {
            if (t.date === targetTodo.date) { // 동일하다면 상태를 바꿔줘야함
                t.isDone = !t.isDone; 
            }
            return t;
        })
        localStorage.setItem("todoList",JSON.stringify(todoList));
        drawTodoList();
    }

    //데이터를 붙여줄 ul요소 가져오기
    const todoUl = document.querySelector(".todo-list");
    todoUl.innerHTML = ""; //비워주기

    for(let todo of todoList) {
        // todoUl.innerHTML += `<li> ${todo.title}
        //     <div class="todo-remove-btn"><i class="fa-solid fa-x"></i></div></li>`

        const todoLi = document.createElement('li'); // <li></li>; 만들어짐
        todoLi.className = todo.isDone ? "done" : "";
        todoLi.innerHTML = todo.title; // <li>${todo.title}</li>; 만들어짐
        todoUl.appendChild(todoLi); // todoUl.innerHTML = <li>${todo.title}</li>; 만들어짐

        const removeBtn = document.createElement('div'); //<div></div> 만들어짐
        removeBtn.className = 'todo-remove-btn'; //<div class="todo-remove-btn"></div> 만들어짐
        removeBtn.innerHTML = '<i class="fa-solid fa-xmark"></i>'; //<i class="fa-solid fa-x"></i> 만들어짐
        todoLi.appendChild(removeBtn); //<div class="todo-remove-btn"><i class="fa-solid fa-x"></i></div> 만들어짐

        todoLi.onclick = function(ev){
            toggleStatus(todo)
        }
        removeBtn.onclick = function(ev){
            //todoList데이터지우기
            removeTodo(todo)
        }
    }
}