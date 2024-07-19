document.addEventListener("DOMContentLoaded", function() {
    const btn = document.getElementById("btn");
    const frm = document.getElementById("frm");

    btn.addEventListener("click", function(event) {
        event.preventDefault(); // 폼 제출 막기
        let fields = ['member_id', 'member_pwd', 'confirmPassword', 'member_name', 'member_number', 'phone', 'email'];
        let isValid = true;

        fields.forEach(field => {
            const errorElement = document.getElementById(field + 'Error');
            if (errorElement) {
                errorElement.textContent = '';
            }
        });

        for (let i = 0; i < fields.length; i++) {
            const fieldValue = document.getElementById(fields[i]).value;
            if (!fieldValue) {
                const errorElement = document.getElementById(fields[i] + 'Error');
                if (errorElement) {
                    errorElement.textContent = '여기에 필수로 입력하세요';
                }
                isValid = false;
            }
        }

        if (document.getElementById("member_pwd").value !== document.getElementById("confirmPassword").value) {
            document.getElementById("confirmPasswordError").textContent = "비밀번호가 일치하지 않습니다.";
            document.getElementById("confirmPassword").value = "";
            isValid = false;
        }

        if (isValid) {
            console.log("Form is valid, submitting form...");
            frm.submit();
        } else {
            console.log("Form is not valid");
            alert("입력된 값들을 확인해 주세요.");
        }
    });
});
