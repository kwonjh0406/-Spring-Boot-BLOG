let index = {
    init: function () {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save: function () {
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
        }).done(function (resp) {
            alert("회원가입이 완료되었습니다.");
            location.href="/";
        }).fail(function (error) {
            alert(JSON.stringify(error));

        }); // ajax 통신으로 3개의 데이터를 json으로 변경하여 insert 요청
    }
}

index.init();