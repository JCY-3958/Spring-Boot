const deleteButton = document.getElementById('delete-btn');
const modifyButton = document.getElementById('modify-btn');
const createButton = document.getElementById('create-btn');


if(deleteButton) {
    deleteButton.addEventListener('click', event =>{
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(()=> {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
        });
    });
}

if(modifyButton) {
    modifyButton.addEventListener('click', event => {
        //URL 주소에 있는 parameter를 가져옴, 파라미터는 여러개일 수 있음
        let params = new URLSearchParams(location.search);
        //여러개 중에 id만 갯또다제
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT', //수정은 put
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}

if(createButton) {
    createButton.addEventListener('click', (event) => {
        fetch("/api/articles", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),
        }). then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/articles");
        });
    });
}