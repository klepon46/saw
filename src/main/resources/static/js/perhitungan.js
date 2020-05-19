$(function() {

    $.ajax({
         url: "/bobot/getKriteria",
         type: 'GET',
         success: function (data) {
                $('#kriteria1').text(data.kriteria1);
                $('#kriteria2').text(data.kriteria2);
                $('#kriteria3').text(data.kriteria3);
                $('#kriteria4').text(data.kriteria4);

                $("#grid-basic").bootgrid({
                        ajax: false,
                        templates: { search: "", actions: "", pagination: "", paginationItem: "", footer: "" }
                });
         }
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