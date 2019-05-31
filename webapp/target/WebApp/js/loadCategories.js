

function loadCategories() {
    $.getJSON('shop',{requestType:'categories'},function (data) {
        var out = '';
        var out_li = '';
        console.log(data);
        for (var key in data){
            out+='<div class="my_categories">';
            out+='<h3><a href ='+data[key]['path']+'>' + data[key]['title'] + '</a></h3>';
            out+='<a href=' + data[key].path + '>' + '<img src="'+data[key].img_path+'" ' +
                '+ width = 200 + height="100">' + '</a>';
            out+='</div>';
        }
        $('#right_column').html(out);
    })
}
function loadLiCategories() {
    $.getJSON('shop',{requestType:'categories'},function (data) {
        var out_li = '';
        for (var key in data){
            out_li+='<li><a href=' + data[key].path + '>' + data[key].title + '</a></li>';
        }
        $('#category_list').html(out_li);
    })
}