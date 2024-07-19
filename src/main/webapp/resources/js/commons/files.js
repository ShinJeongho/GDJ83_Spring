document.addEventListener("DOMContentLoaded", function() {
    const addPhotoBtn = document.getElementById("add");
    const photoFieldsContainer = document.getElementById("photoFields");

    addPhotoBtn.addEventListener("click", function() {
        // 기존에 추가된 파일 입력 필드가 있는지 확인
        const existingPhotoInput = photoFieldsContainer.querySelector("input[type='file']");
        if (existingPhotoInput) {
            alert("이미 사진이 추가되었습니다.");
        } else {
            // 파일 입력 필드와 삭제 버튼을 감싸는 div 요소 생성
            const photoFieldDiv = document.createElement("div");
            photoFieldDiv.className = "photoField";
            photoFieldDiv.style.position = "relative";

            // 파일 입력 요소 생성
            const photoInput = document.createElement("input");
            photoInput.type = "file";
            photoInput.name = "file";
            photoInput.className = "form-control mb-2";

            // 삭제 버튼 생성
            const removePhotoBtn = document.createElement("button");
            removePhotoBtn.type = "button";
            removePhotoBtn.className = "btn btn-danger";
            removePhotoBtn.textContent = "X";
            removePhotoBtn.style.position = "absolute";
            removePhotoBtn.style.right = "10px";
            removePhotoBtn.style.top = "50%";
            removePhotoBtn.style.transform = "translateY(-50%)";

            // 삭제 버튼 클릭 시 해당 파일 입력 필드를 제거하는 이벤트 리스너
            removePhotoBtn.addEventListener("click", function() {
                photoFieldDiv.remove();
            });

            // 파일 입력 요소와 삭제 버튼을 div에 추가
            photoFieldDiv.appendChild(photoInput);
            photoFieldDiv.appendChild(removePhotoBtn);
            // div를 컨테이너에 추가
            photoFieldsContainer.appendChild(photoFieldDiv);
        }
    });
});
