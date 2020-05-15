$(function() {
    $("#grid-basic").bootgrid({
        ajax: false,
        templates: { search: "", actions: "", pagination: "", paginationItem: "", footer: "" }
    });

    $("#grid-peringkat").bootgrid({
            ajax: false,
            templates: { search: "", actions: "", pagination: "", paginationItem: "", footer: "" }
    });

    var datas = [];
    $('#normalisasi').click(function(){
        $("#grid-basic").bootgrid('clear');
        $.ajax({
                url: "/perhitungan/hitung",
                type: 'GET',
                success: function (data) {
                    $("#grid-basic").bootgrid('append', data);
                    datas = data;

                    console.log(datas);
                }
        });
    });

    $('#peringkat').click(function(){
    $("#grid-peringkat").bootgrid('clear');
        $.ajax({
            url: "/perhitungan/peringkat",
            type: 'GET',
            success: function (data) {
                $("#grid-peringkat").bootgrid('append', data);
            }
        });
    });


});