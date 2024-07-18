document.addEventListener("DOMContentLoaded", function() {
    const addPhotoBtn = document.getElementById("add"); // 사진 추가 버튼 요소를 가져옴
    const photoFieldsContainer = document.getElementById("photoFields"); // 사진 입력 필드들이 추가될 컨테이너

    // 사진 추가 버튼 클릭 시 실행되는 이벤트 리스너
    addPhotoBtn.addEventListener("click", function() {
        const photoFieldDiv = document.createElement("div"); // 새 div 요소 생성
        photoFieldDiv.className = "photoField"; // div 요소에 클래스 이름 설정
        photoFieldDiv.style.position = "relative"; // 삭제 버튼 위치를 설정하기 위해 position을 relative로 설정

        const photoInput = document.createElement("input"); // 새 파일 입력 요소 생성
        photoInput.type = "file"; // 입력 요소 타입을 파일로 설정
        photoInput.name = "photo"; // 입력 요소 이름 설정
        photoInput.className = "form-control mb-2"; // 입력 요소에 클래스 이름 설정

        const removePhotoBtn = document.createElement("button"); // 삭제 버튼 생성
        removePhotoBtn.type = "button"; // 버튼 타입 설정
        removePhotoBtn.className = "btn btn-danger"; // 버튼에 클래스 이름 설정
        removePhotoBtn.textContent = "X"; // 버튼에 표시될 텍스트 설정
        removePhotoBtn.style.position = "absolute"; // 삭제 버튼 위치를 절대 위치로 설정
        removePhotoBtn.style.right = "10px"; // 삭제 버튼을 입력 필드의 오른쪽 끝에 배치
        removePhotoBtn.style.top = "50%"; // 삭제 버튼을 입력 필드의 가운데에 배치
        removePhotoBtn.style.transform = "translateY(-50%)"; // 삭제 버튼을 입력 필드의 가운데로 이동

        // 삭제 버튼 클릭 시 해당 파일 입력 필드를 제거하는 이벤트 리스너
        removePhotoBtn.addEventListener("click", function() {
            photoFieldDiv.remove(); // 파일 입력 필드를 포함한 div 요소 제거
        });

        photoFieldDiv.appendChild(photoInput); // 파일 입력 요소를 div에 추가
        photoFieldDiv.appendChild(removePhotoBtn); // 삭제 버튼을 div에 추가
        photoFieldsContainer.appendChild(photoFieldDiv); // 완성된 div를 컨테이너에 추가
    });
});

