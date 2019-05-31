username_login = '';
var main = {
    registration: function () {
        var login = document.getElementById("logReg").value;
        alert(login);
        var pass = document.getElementById("passReg").value;
        var email = document.getElementById("mailReg").value;
        $.ajax({
            type: "POST",
            url: "shop",
            dataType: "json",
            data: {requestType: "registration", login: login, password: pass, email: email},
            success: function (data) {
                if (data.name == "error")
                    document.location.href = 'errorPage.html';
                else {
                    if (localStorage.getItem('user') != null) {
                        localStorage.removeItem('user');
                    }
                    localStorage.setItem("user", JSON.stringify(data.username));
                    alert("Поздравляем! Вы успешно зарегистрированы в интернет-магазине!" +
                        "Теперь вы можете совершать покупки! Ваш логин: " + data.username + " Ваш id : " + data.userId);
                    document.location.href = 'index.html';
                }
            }
        });
    },

    log_in: function () {
        var login = document.getElementById("login").value;
        var password = document.getElementById("password").value;
        alert(login + " " + password);
        $.ajax({
            type: "POST",
            url: "shop",
            dataType: "json",
            data: {requestType: "login", login: login, password: password},
            success: function (data) {
                if (data.name == "error") {
                    alert("Incorrect data");
                }
                else {
                    localStorage.setItem('user', JSON.stringify(data.username));
                    alert("Вы успешно вошли как " + data.username);
                    document.location.href = 'index.html';
                }
            }
        });
    }
};