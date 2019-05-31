var order = {};
checkOrder();
showOrder();

function checkOrder() {
    //проверяю наличие корзины в localStorage;
    if (localStorage.getItem('order') != null) {
        order = JSON.parse(localStorage.getItem('order'));
        console.log(order);
    }
}

function showOrder() {
    if ($.isEmptyObject(order)) {
        var empty = 'Корзина пуста. Добавьте товар в корзину <a href="index.html">Главная страница</a>';
        $('#products_in_order').html(empty);
    } else {

        var out = '';
        for (var key in order) {
            $.ajax({
                dataType: "json",
                url: 'shop',
                data: {requestType: 'product', id: key},
                async: false,
                success: function (data) {
                    out += '<button class="delete_btn"data-art="' + key + '">x</button>';
                    out += '<img src=' + data.img_path + ' width="200" height="100">';
                    out += data.title;
                    out += '<button class="minus_btn" data-art="' + key + '">-</button>';
                    out += order[key];
                    out += '<button class="plus_btn" data-art="' + key + '">+</button>';
                    out += order[key] * data.price;
                    out += '<br>';
                }
            })
        }
        out += '<button id="accept">Оформить заказ</button>';
    }
    $('#products_in_order').html(out);
    $('.plus_btn').on('click', function () {
        var id = $(this).attr('data-art');
        order[id]++;
        saveToLS();
        showOrder();
    });
    $('#accept').on('click', function () {
        if (localStorage.getItem('user') != null) {
            var username = localStorage.getItem('user');
            for (var key in order) {
                $.ajax({
                    dataType: "json",
                    url: 'shop',
                    data: {requestType: 'order', productId: key, quantity: order[key], user: username},
                    async: false,
                    success: function (data) {
                        alert("succes");
                    }
                })
            } alert("Заказ принят, с вами свяжется менеджер в ближайшее время");
        } else {
            var ok = confirm("Для подтверждения заказа нужно войти в свой аккаунт");
            if (ok) {
                document.location.href = "login.html";
            } else {
                document.location.href = "index.html"
            }
        }
    });
    $('.minus_btn').on('click', function () {
        var id = $(this).attr('data-art');
        if (order[id] > 1) {
            order[id]--;
        } else {
            delete order[id];

        }
        saveToLS();
        showOrder();
    });
    $('.delete_btn').on('click', function () {
        var id = $(this).attr('data-art');
        delete order[id];
        saveToLS();
        showOrder();
    });
}

function saveToLS() {
    localStorage.setItem('order', JSON.stringify(order));
}

