$(function(){
    $("#grid-basic").bootgrid({
        ajax: false,
        templates: { search: "", actions: "", pagination: "", paginationItem: "", footer: "" }
    });

    $('#generate').click(function(){
        $("#grid-basic").bootgrid('clear');

        var year = $('#YearFullid').children("option:selected").val();
        var period = $('#period').children("option:selected").val();

        $.ajax({
            url: "/perhitungan/peringkatFilter?kuartal="+period+"&year="+year,
            type: 'GET',
            success: function (data) {
                $("#grid-basic").bootgrid('append', data);
            }
        });
    });

    $('#report').click(function(){
        var year = $('#YearFullid').children("option:selected").val();
        var period = $('#period').children("option:selected").val();
        $.ajax({
            url: "/periode/report?kuartal="+period+"&year="+year,
            type: 'GET',
            success: function (data) {

            }
        });
    });
});