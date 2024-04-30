/*const editor = new toastui.Editor({
    el: document.querySelector('#content'),      // 에디터를 적용할 요소 (컨테이너)
    height: '500px',                             // 에디터 영역의 높이 값 (OOOpx || auto)
    initialEditType: 'wysiwyg',                 // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
    initialValue: '',                            // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
    previewStyle: 'vertical',                    // 마크다운 프리뷰 스타일 (tab || vertical)
    placeholder: '',
    /!* start of hooks *!/
    hooks: {
        async addImageBlobHook(blob, callback) { // 이미지 업로드 로직 커스텀
            try {
                /!*
                 * 1. 에디터에 업로드한 이미지를 FormData 객체에 저장
                 *    (이때, 컨트롤러 uploadEditorImage 메서드의 파라미터인 'image'와 formData에 append 하는 key('image')값은 동일해야 함)
                 *!/
                const formData = new FormData();
                formData.append('image', blob);

                // 2. FileApiController - uploadEditorImage 메서드 호출
                const response = await fetch('/tui-editor/image-upload', {
                    method : 'POST',
                    body : formData,
                });

                // 3. 컨트롤러에서 전달받은 디스크에 저장된 파일명
                const filename = await response.text();
                console.log('서버에 저장된 파일명 : ', filename);

                // 4. addImageBlobHook의 callback 함수를 통해, 디스크에 저장된 이미지를 에디터에 렌더링
                const imageUrl = `/tui-editor/image-print?filename=${filename}`;
                callback(imageUrl, 'image alt attribute');

            } catch (error) {
                console.error('업로드 실패 : ', error);
            }
        }
    }
    /!* end of hooks *!/
});


// 게시글 저장
async function savePost() {
    // 1. 콘텐츠 입력 유효성 검사
    if (editor.getMarkdown().length < 1) {
        alert('에디터 내용을 입력해 주세요.');
        throw new Error('editor content is required!');
    }

    // 2. url, parameter 세팅
    const url = '/api/portfolio';

    // 3. API 호출
    try {
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title:document.getElementById("title").value,
                portName:document.getElementById("name").value,
                phone:document.getElementById("phone").value,
                portEmail:document.getElementById("email").value,
                summary:document.getElementById("line").value,
                mySkill:document.getElementById("skill").value,
                projectIntro: editor.getHTML(),
            }),
        });

        const postId = await response.json();
        alert(postId + '번 게시글이 저장되었습니다.');
        location.href = '/portfolio';

    } catch (error) {
        console.error('저장 실패 : ', error)
    }
}*/
//---------------------------toast Ui 끝------------------------------------

const createButton = document.getElementById('create-btn');

if(createButton) {
    createButton.addEventListener('click', (event) => {
        if(!document.getElementById("title").value) {
            alert("제목, 프로젝트 소개 입력해라");
            return;
        }

        if(!document.getElementById("intro").value) {
            alert("제목, 프로젝트 소개 입력해라");
            return;
        }

        fetch("/api/portfolio", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title:document.getElementById("title").value,
                portName:document.getElementById("name").value,
                phone:document.getElementById("phone").value,
                portEmail:document.getElementById("email").value,
                summary:document.getElementById("line").value,
                mySkill:document.getElementById("skill").value,
                projectIntro: document.getElementById("intro").value,
            }),
        }). then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/portfolio");
        });

    });
}

const modifyButton = document.getElementById('modify-btn');

if(modifyButton) {
    modifyButton.addEventListener('click', (event) => {
        console.log("이거 댐?");
        let params = new URLSearchParams(location.search);
        //여러개 중에 id만 갯또다제
        let id = params.get("id");
        fetch(`/api/portfolio/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title:document.getElementById("title").value,
                portName:document.getElementById("name").value,
                phone:document.getElementById("phone").value,
                portEmail:document.getElementById("email").value,
                summary:document.getElementById("line").value,
                mySkill:document.getElementById("skill").value,
                projectIntro: document.getElementById("intro").value,
            })
        })
            .then(() => {
                alert("수정 완료");
                location.replace(`/portfolio/${id}`);
            });
    });
}

const deleteButton = document.getElementById('delete-btn');
if(deleteButton) {
    deleteButton.addEventListener('click', (event) =>{
        let id = document.getElementById('portfolio-id').value;
        fetch(`/api/portfolio/${id}`, {
            method: 'DELETE'
        })
            .then(()=> {
                alert('삭제가 완료되었습니다.');
                location.replace('/portfolio');
        });
    });
}

const RepresentButton = document.getElementById('represent-btn');
if(RepresentButton) {
    RepresentButton.addEventListener('click', (event) =>{
        let id = document.getElementById('portfolio-id').value;
        console.log("이겁니다:" + id);
        fetch(`/api2/portfolio/${id}`, {
            method: 'POST'
        })
            .then(()=> {
                alert('대표 등록이 완료되었습니다.');
                location.replace('/portfolio');
            });
    });
}