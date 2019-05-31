var order = {};

function loadProducts(category) {
    //загружаю товары на страницу
    $.getJSON('shop', {requestType:'product',category:category}, function (data) {
        console.log(data);
        var out = '';
        var out_li = '';
        for (var key in data){

            out+='<div class="products">';
            out+='<h3>'+data[key]['title']+'</h3>';
            out+='<p>Цена: '+data[key]['price']+'</p>';
            out+='<img src="'+data[key].img_path+'" + width = 200 + height="100">';
            out+='<p>'+data[key]['description']+'</p>';
            out+='<button class="add_2_order" data-art="'+data[key]['id']+'">В корзину</button>';
            out+='</div>';
            out_li+='<li><a href=' + data[key].path + '>' + data[key].title + '</a></li>';
        }
        $('#category_list').html(out_li);
        $('#products').html(out);
        $('button.add_2_order').on('click', function () {
            //добавляем товар в корзину

            var productId = $(this).attr('data-art');
            if (order[productId]!=undefined) {
                order[productId]++;
            }
            else {
                order[productId] = 1;
            }
            localStorage.setItem('order', JSON.stringify(order) );
            console.log(order);
        });
    });
}





