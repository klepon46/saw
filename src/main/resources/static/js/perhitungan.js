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
        var year = $('#YearFullid').children("option:selected").val();
        var period = $('#period').children("option:selected").val();

        $.ajax({
                url: "/perhitungan/hitungFilter?kuartal="+period+"&year="+year,
                type: 'GET',
                success: function (data) {
                    $("#grid-basic").bootgrid('append', data);
                    datas = data;


                }
        });
    });

    $('#peringkat').click(function(){
            $("#grid-peringkat").bootgrid('clear');
            if(datas.length == 0){
                alert("Data belum di normalisasi");
                return;
            }

            var year = $('#YearFullid').children("option:selected").val();
            var period = $('#period').children("option:selected").val();

            $.ajax({
                url: "/perhitungan/peringkatFilter?kuartal="+period+"&year="+year,
                type: 'GET',
                success: function (data) {
                    $("#grid-peringkat").bootgrid('append', data);
                }
            });
    });


});